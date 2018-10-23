/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.sdk.iot.provisioning.service.models;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * X509 certificate info.
 */
public class X509CertificateInfo
{
	/**
	 * The subjectName property.
	 */
	@JsonProperty(value = "subjectName", required = true)
	private String subjectName;

	/**
	 * The sha1Thumbprint property.
	 */
	@JsonProperty(value = "sha1Thumbprint", required = true)
	private String sha1Thumbprint;

	/**
	 * The sha256Thumbprint property.
	 */
	@JsonProperty(value = "sha256Thumbprint", required = true)
	private String sha256Thumbprint;

	/**
	 * The issuerName property.
	 */
	@JsonProperty(value = "issuerName", required = true)
	private String issuerName;

	/**
	 * The notBeforeUtc property.
	 */
	@JsonProperty(value = "notBeforeUtc", required = true)
	private DateTime notBeforeUtc;

	/**
	 * The notAfterUtc property.
	 */
	@JsonProperty(value = "notAfterUtc", required = true)
	private DateTime notAfterUtc;

	/**
	 * The serialNumber property.
	 */
	@JsonProperty(value = "serialNumber", required = true)
	private String serialNumber;

	/**
	 * The version property.
	 */
	@JsonProperty(value = "version", required = true)
	private int version;

	/**
	 * Get the subjectName value.
	 *
	 * @return the subjectName value
	 */
	public String subjectName()
	{
		return this.subjectName;
	}

	/**
	 * Set the subjectName value.
	 *
	 * @param subjectName the subjectName value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
		return this;
	}

	/**
	 * Get the sha1Thumbprint value.
	 *
	 * @return the sha1Thumbprint value
	 */
	public String sha1Thumbprint()
	{
		return this.sha1Thumbprint;
	}

	/**
	 * Set the sha1Thumbprint value.
	 *
	 * @param sha1Thumbprint the sha1Thumbprint value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withSha1Thumbprint(String sha1Thumbprint)
	{
		this.sha1Thumbprint = sha1Thumbprint;
		return this;
	}

	/**
	 * Get the sha256Thumbprint value.
	 *
	 * @return the sha256Thumbprint value
	 */
	public String sha256Thumbprint()
	{
		return this.sha256Thumbprint;
	}

	/**
	 * Set the sha256Thumbprint value.
	 *
	 * @param sha256Thumbprint the sha256Thumbprint value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withSha256Thumbprint(String sha256Thumbprint)
	{
		this.sha256Thumbprint = sha256Thumbprint;
		return this;
	}

	/**
	 * Get the issuerName value.
	 *
	 * @return the issuerName value
	 */
	public String issuerName()
	{
		return this.issuerName;
	}

	/**
	 * Set the issuerName value.
	 *
	 * @param issuerName the issuerName value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withIssuerName(String issuerName)
	{
		this.issuerName = issuerName;
		return this;
	}

	/**
	 * Get the notBeforeUtc value.
	 *
	 * @return the notBeforeUtc value
	 */
	public DateTime notBeforeUtc()
	{
		return this.notBeforeUtc;
	}

	/**
	 * Set the notBeforeUtc value.
	 *
	 * @param notBeforeUtc the notBeforeUtc value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withNotBeforeUtc(DateTime notBeforeUtc)
	{
		this.notBeforeUtc = notBeforeUtc;
		return this;
	}

	/**
	 * Get the notAfterUtc value.
	 *
	 * @return the notAfterUtc value
	 */
	public DateTime notAfterUtc()
	{
		return this.notAfterUtc;
	}

	/**
	 * Set the notAfterUtc value.
	 *
	 * @param notAfterUtc the notAfterUtc value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withNotAfterUtc(DateTime notAfterUtc)
	{
		this.notAfterUtc = notAfterUtc;
		return this;
	}

	/**
	 * Get the serialNumber value.
	 *
	 * @return the serialNumber value
	 */
	public String serialNumber()
	{
		return this.serialNumber;
	}

	/**
	 * Set the serialNumber value.
	 *
	 * @param serialNumber the serialNumber value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
		return this;
	}

	/**
	 * Get the version value.
	 *
	 * @return the version value
	 */
	public int version()
	{
		return this.version;
	}

	/**
	 * Set the version value.
	 *
	 * @param version the version value to set
	 * @return the X509CertificateInfo object itself.
	 */
	public X509CertificateInfo withVersion(int version)
	{
		this.version = version;
		return this;
	}

}