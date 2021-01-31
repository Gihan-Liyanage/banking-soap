//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.31 at 01:28:25 PM IST 
//


package com.trebeyainterview.spring_boot_soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ownTransferOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ownTransferOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="from_account" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="to_account" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="from_balance" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="to_balance" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ownTransferOutput", propOrder = {
    "userId",
    "fromAccount",
    "toAccount",
    "amount",
    "fromBalance",
    "toBalance"
})
public class OwnTransferOutput {

    @XmlElement(name = "user_id", required = true)
    protected String userId;
    @XmlElement(name = "from_account", required = true)
    protected String fromAccount;
    @XmlElement(name = "to_account", required = true)
    protected String toAccount;
    protected double amount;
    @XmlElement(name = "from_balance")
    protected double fromBalance;
    @XmlElement(name = "to_balance")
    protected double toBalance;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the fromAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromAccount() {
        return fromAccount;
    }

    /**
     * Sets the value of the fromAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromAccount(String value) {
        this.fromAccount = value;
    }

    /**
     * Gets the value of the toAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToAccount() {
        return toAccount;
    }

    /**
     * Sets the value of the toAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToAccount(String value) {
        this.toAccount = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the fromBalance property.
     * 
     */
    public double getFromBalance() {
        return fromBalance;
    }

    /**
     * Sets the value of the fromBalance property.
     * 
     */
    public void setFromBalance(double value) {
        this.fromBalance = value;
    }

    /**
     * Gets the value of the toBalance property.
     * 
     */
    public double getToBalance() {
        return toBalance;
    }

    /**
     * Sets the value of the toBalance property.
     * 
     */
    public void setToBalance(double value) {
        this.toBalance = value;
    }

}
