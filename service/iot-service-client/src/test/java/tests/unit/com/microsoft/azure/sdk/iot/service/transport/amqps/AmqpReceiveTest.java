/*
 * Copyright (c) Microsoft. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */

package tests.unit.com.microsoft.azure.sdk.iot.service.transport.amqps;

import com.microsoft.azure.sdk.iot.service.FeedbackBatchMessage;
import com.microsoft.azure.sdk.iot.service.IotHubServiceClientProtocol;
import com.microsoft.azure.sdk.iot.service.transport.amqps.AmqpFeedbackReceivedHandler;
import com.microsoft.azure.sdk.iot.service.transport.amqps.AmqpReceive;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.apache.qpid.proton.Proton;
import org.apache.qpid.proton.engine.Connection;
import org.apache.qpid.proton.engine.Event;
import org.apache.qpid.proton.message.Message;
import org.apache.qpid.proton.reactor.Reactor;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/** Unit tests for AmqpReceive */
@RunWith(JMockit.class)
public class AmqpReceiveTest
{
    @Mocked Proton proton;
    @Mocked Reactor reactor;
    @Mocked Event event;
    @Mocked Connection connection;
    @Mocked Message message;
    
    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_001: [The constructor shall copy all input parameters to private member variables for event processing]
    @Test
    public void amqpReceive_init_ok()
    {
        // Arrange
        String hostName = "aaa";
        String userName = "bbb";
        String sasToken = "ccc";
        IotHubServiceClientProtocol iotHubServiceClientProtocol = IotHubServiceClientProtocol.AMQPS;
        // Act
        AmqpReceive amqpReceive = new AmqpReceive(hostName, userName, sasToken, iotHubServiceClientProtocol);
        String _hostName = Deencapsulation.getField(amqpReceive, "hostName");
        String _userName = Deencapsulation.getField(amqpReceive, "userName");
        String _sasToken = Deencapsulation.getField(amqpReceive, "sasToken");
        // Assert
        assertEquals(hostName, _hostName);
        assertEquals(userName, _userName);
        assertEquals(sasToken, _sasToken);
    }

    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_002: [The event handler shall set the member AmqpsReceiveHandler object to handle the given connection events]
    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_003: [The function shall create an AmqpsReceiveHandler object to handle reactor events]
    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_004: [The function shall invalidate the member AmqpsReceiveHandler object]
    @Test
    public void onReactorInit_call_flow_and_init_ok() throws IOException
    {
        // Arrange
        String hostName = "aaa";
        String userName = "bbb";
        String sasToken = "ccc";
        IotHubServiceClientProtocol iotHubServiceClientProtocol = IotHubServiceClientProtocol.AMQPS;
        AmqpReceive amqpReceive = new AmqpReceive(hostName, userName, sasToken, iotHubServiceClientProtocol);
        amqpReceive.open();
        // Assert
        new Expectations()
        {
            {
                reactor = event.getReactor();
                connection = reactor.connection(Deencapsulation.getField(amqpReceive, "amqpReceiveHandler"));
            }
        };
        // Act
        amqpReceive.onReactorInit(event);
        amqpReceive.close();
        // Assert
        assertNull(Deencapsulation.getField(amqpReceive, "amqpReceiveHandler"));
    }

    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_005: [The function shall initialize the Proton reactor object]
    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_006: [The function shall start the Proton reactor object]
    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_008: [The function shall stop and free the Proton reactor object ]
    @Test
    public void receive_with_timout_zero_call_flow_ok(@Mocked AmqpFeedbackReceivedHandler mockAmqpFeedbackReceivedHandler) throws IOException, InterruptedException
    {
        // Arrange
        String hostName = "aaa";
        String userName = "bbb";
        String sasToken = "ccc";
        IotHubServiceClientProtocol iotHubServiceClientProtocol = IotHubServiceClientProtocol.AMQPS;
        int timeoutMs = 0;
        AmqpReceive amqpReceive = new AmqpReceive(hostName, userName, sasToken, iotHubServiceClientProtocol);
        amqpReceive.open();
        // Assert
        new Expectations()
        {
            {
                reactor = proton.reactor(amqpReceive);
                reactor.start();
                reactor.stop();
                reactor.process();
                reactor.free();
        
            }
        };
        // Act
        amqpReceive.receive(timeoutMs);
    }

    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_005: [The function shall initialize the Proton reactor object]
    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_006: [The function shall start the Proton reactor object]
    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_008: [The function shall stop and free the Proton reactor object ]
    @Test
    public void receiveWithTimout_non_zero_call_ok(@Mocked AmqpFeedbackReceivedHandler mockAmqpFeedbackReceivedHandler) throws IOException, InterruptedException
    {
        // Arrange
        String hostName = "aaa";
        String userName = "bbb";
        String sasToken = "ccc";
        IotHubServiceClientProtocol iotHubServiceClientProtocol = IotHubServiceClientProtocol.AMQPS;
        int timeoutMs = 1;
        AmqpReceive amqpReceive = new AmqpReceive(hostName, userName, sasToken, iotHubServiceClientProtocol);
        amqpReceive.open();
        // Assert
        new Expectations()
        {
            {
                reactor = proton.reactor(amqpReceive);
                reactor.start();
                reactor.stop();
                reactor.process();
                reactor.free();
                
                
                
            }
        };
        // Act
        amqpReceive.receive(timeoutMs);
    }

    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_008: [The function shall throw IOException if the send handler object is not initialized]
    // Assert
    @Test (expected = IOException.class)
    public void receiveException_throw() throws IOException, InterruptedException
    {
        // Arrange
        String hostName = "aaa";
        String userName = "bbb";
        String sasToken = "ccc";
        IotHubServiceClientProtocol iotHubServiceClientProtocol = IotHubServiceClientProtocol.AMQPS;
        int timeoutMs = 1;
        AmqpReceive amqpReceive = new AmqpReceive(hostName, userName, sasToken, iotHubServiceClientProtocol);
        // Act
        amqpReceive.receive(timeoutMs);
    }

    // Tests_SRS_SERVICE_SDK_JAVA_AMQPRECEIVE_12_010: [The function shall parse the received Json string to FeedbackBath object]
    @Test
    public void onFeedbackReceived_call_flow_ok()
    {
        // Arrange
        String hostName = "aaa";
        String userName = "bbb";
        String sasToken = "ccc";
        String jsonData = "[]";
        IotHubServiceClientProtocol iotHubServiceClientProtocol = IotHubServiceClientProtocol.AMQPS;
        AmqpReceive amqpReceive = new AmqpReceive(hostName, userName, sasToken, iotHubServiceClientProtocol);
        // Assert
        new Expectations()
        {
            {
                FeedbackBatchMessage.parse(jsonData);
                
            }
        };
        // Act
        amqpReceive.onFeedbackReceived(jsonData);
    }
}
