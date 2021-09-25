# Run 
1. http://localhost:8080/server/login


# Todo Server List
1. Verify request params in AuthorizeController are valid
2. generate Code in ApproveController
3. Implement Refresh Token Flow 
4. /Token needs to verify grant_type,code,redirect_uri,client_id are valid
5. CSRF Protection



# Todo Client List
1. in /callback generate valid TokenInput AND verify state param is correct
2. login.html hardcodes all the oidc configs
3. Client needs to generate a state for CSRF protection
4. State validation client side
5. Client needs to store oauth config in a db or cache
6. once client has AT/IT/RT it should create a session of somesort and login 
7. when trying to fetch a resource, trap the error and try to use refresh token calling the /token endpoint
   1. https://livebook.manning.com/book/oauth-2-in-action/chapter-3/point-14137-115-117-0
8. Client is living in same code base with server. Would be nice to split it out better
9. do DCR

# Todo UI
1. Would be nice to have a real UI..

# Where i am on Manning 
https://livebook.manning.com/book/oauth-2-in-action/chapter-4