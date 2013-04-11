/**
 * SoapMapValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ismart.entity;


public class SoapMapValue  implements java.io.Serializable {
    private java.lang.String[] arrayValue;

    private SoapMap[] mapArrayValue;

    private java.lang.String name;

    private java.lang.String singleValue;

    public SoapMapValue() {
    }

    public SoapMapValue(
           java.lang.String[] arrayValue,
           SoapMap[] mapArrayValue,
           java.lang.String name,
           java.lang.String singleValue) {
           this.arrayValue = arrayValue;
           this.mapArrayValue = mapArrayValue;
           this.name = name;
           this.singleValue = singleValue;
    }


    /**
     * Gets the arrayValue value for this SoapMapValue.
     * 
     * @return arrayValue
     */
    public java.lang.String[] getArrayValue() {
        return arrayValue;
    }


    /**
     * Sets the arrayValue value for this SoapMapValue.
     * 
     * @param arrayValue
     */
    public void setArrayValue(java.lang.String[] arrayValue) {
        this.arrayValue = arrayValue;
    }


    /**
     * Gets the mapArrayValue value for this SoapMapValue.
     * 
     * @return mapArrayValue
     */
    public SoapMap[] getMapArrayValue() {
        return mapArrayValue;
    }


    /**
     * Sets the mapArrayValue value for this SoapMapValue.
     * 
     * @param mapArrayValue
     */
    public void setMapArrayValue(SoapMap[] mapArrayValue) {
        this.mapArrayValue = mapArrayValue;
    }


    /**
     * Gets the name value for this SoapMapValue.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this SoapMapValue.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the singleValue value for this SoapMapValue.
     * 
     * @return singleValue
     */
    public java.lang.String getSingleValue() {
        return singleValue;
    }


    /**
     * Sets the singleValue value for this SoapMapValue.
     * 
     * @param singleValue
     */
    public void setSingleValue(java.lang.String singleValue) {
        this.singleValue = singleValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapMapValue)) return false;
        SoapMapValue other = (SoapMapValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayValue==null && other.getArrayValue()==null) || 
             (this.arrayValue!=null &&
              java.util.Arrays.equals(this.arrayValue, other.getArrayValue()))) &&
            ((this.mapArrayValue==null && other.getMapArrayValue()==null) || 
             (this.mapArrayValue!=null &&
              java.util.Arrays.equals(this.mapArrayValue, other.getMapArrayValue()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.singleValue==null && other.getSingleValue()==null) || 
             (this.singleValue!=null &&
              this.singleValue.equals(other.getSingleValue())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArrayValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMapArrayValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMapArrayValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMapArrayValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getSingleValue() != null) {
            _hashCode += getSingleValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapMapValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:openApi", "SoapMapValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapArrayValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapArrayValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:openApi", "SoapMap"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("singleValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "singleValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}