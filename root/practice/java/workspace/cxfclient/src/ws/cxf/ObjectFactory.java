
package ws.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.cxf package. 
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

    private final static QName _F_QNAME = new QName("http://cxf.ws/", "f");
    private final static QName _F2_QNAME = new QName("http://cxf.ws/", "f2");
    private final static QName _F2Response_QNAME = new QName("http://cxf.ws/", "f2Response");
    private final static QName _FResponse_QNAME = new QName("http://cxf.ws/", "fResponse");
    private final static QName _GetUser_QNAME = new QName("http://cxf.ws/", "getUser");
    private final static QName _GetUserResponse_QNAME = new QName("http://cxf.ws/", "getUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.cxf
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
     * Create an instance of {@link F2 }
     * 
     */
    public F2 createF2() {
        return new F2();
    }

    /**
     * Create an instance of {@link F2Response }
     * 
     */
    public F2Response createF2Response() {
        return new F2Response();
    }

    /**
     * Create an instance of {@link FResponse }
     * 
     */
    public FResponse createFResponse() {
        return new FResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link F }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.ws/", name = "f")
    public JAXBElement<F> createF(F value) {
        return new JAXBElement<F>(_F_QNAME, F.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link F2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.ws/", name = "f2")
    public JAXBElement<F2> createF2(F2 value) {
        return new JAXBElement<F2>(_F2_QNAME, F2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link F2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.ws/", name = "f2Response")
    public JAXBElement<F2Response> createF2Response(F2Response value) {
        return new JAXBElement<F2Response>(_F2Response_QNAME, F2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.ws/", name = "fResponse")
    public JAXBElement<FResponse> createFResponse(FResponse value) {
        return new JAXBElement<FResponse>(_FResponse_QNAME, FResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.ws/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.ws/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

}
