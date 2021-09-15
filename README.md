# idp

I am creating this project to learn mutliple industry standard concepts. This readme will change overtime.


## Vocabulary

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

## Goals

1. Create Authorization Server - analogy would be im the hotel and i give the key to the client, who can then access the gym, pool, and room etc.
