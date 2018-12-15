
package com.demoserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demoserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FResponse_QNAME = new QName("http://impl.demo.com/", "fResponse");
    private final static QName _F_QNAME = new QName("http://impl.demo.com/", "f");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demoserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link F }
     * 
     */
    public F createF() {
        return new F();
    }

    /**
     * Create an instance of {@link FResponse }
     * 
     */
    public FResponse createFResponse() {
        return new FResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.demo.com/", name = "fResponse")
    public JAXBElement<FResponse> createFResponse(FResponse value) {
        return new JAXBElement<FResponse>(_FResponse_QNAME, FResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link F }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.demo.com/", name = "f")
    public JAXBElement<F> createF(F value) {
        return new JAXBElement<F>(_F_QNAME, F.class, null, value);
    }

}
