# idp

I am creating this project to learn mutliple industry standard concepts. This readme will change overtime.


## Vocabulary

JPA - https://www.geeksforgeeks.org/java-jpa-vs-hibernate/

IDP - An identity provider (IdP) is a service that stores and manages digital identities. Companies use these services to allow their employees or users to connect with the resources they need. They provide a way to manage access, adding or removing privileges, while security remains tight.
https://www.okta.com/identity-101/why-your-company-needs-an-identity-provider/

IAM - identity and access management 

Oauth2.0 - is a standard that apps use to provide client applications with access. If you would like to grant access to your application data in a secure way, then you want to use the OAuth 2.0 protocol. Accessing APIs. OAuth was created as a delegated authorization protocol. It has been extended to be used as a single-sign-on protocol through things like OpenID Connect, but that was not its original goal.

OIDC(Open ID Connect) - OpenID Connect is an authentication standard built on top of OAuth 2.0. It adds an additional token called an ID token. OpenID Connect also standardizes areas that OAuth 2.0 leaves up to choice, such as scopes, endpoint discovery, and dynamic registration of clients. Extension of Oauth. Oauth gives Id token, oauth really only gives access/refresh token. Identifying users

https://developer.okta.com/docs/concepts/oauth-openid/

Authentication vs Authorization - Authentication confirms that users are who they say they are. Authorization gives those users permission to access a resource.
https://www.okta.com/identity-101/authentication-vs-authorization/
https://www.oauth.com/oauth2-servers/openid-connect/authorization-vs-authentication/

Password Grant is bad... No way to know if user consented to the request

BackChannel - client to server https request(normal). Example == hand delivering a package.

FrontChannel - using browser address bar to handle package. Leaves room for a lot of "Cheating" since you dont know where the package is going / when you received the response if it was tampered. Using broswer to transfer data.

Implicit flow is bad? No backchannel.
https://aaronparecki.com/oauth-2-simplified/
## Goals

1. Create Authorization Server - analogy would be im the hotel and i give the key to the client, who can then access the gym, pool, and room etc.


## Spring Boot
1. https://www.baeldung.com/spring-controller-vs-restcontroller Controller vs RestController
2. Getting started tutorial https://spring.io/guides/gs/spring-boot/
3. Request Mapping Annotation - https://dzone.com/articles/using-the-spring-requestmapping-annotation
4. Securing your web app - https://spring.io/guides/gs/securing-web/

### Spring Boot Annotations
1. @Component - allows Spring to automatically detect our custom beans. https://www.baeldung.com/spring-component-annotation


Complete the tasks here
https://docs.microsoft.com/en-us/azure/active-directory/app-provisioning/use-scim-to-provision-users-and-groups