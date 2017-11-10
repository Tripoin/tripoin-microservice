/*
// insert with ConfigAuthServer.java

insert into oauth_client_details (
  client_id,
  resource_ids,
  client_secret,
  scope,
  authorized_grant_types,
  web_server_redirect_uri,
  authorities,
  access_token_validity,
  refresh_token_validity,
  additional_information,
  autoapprove) VALUES (
  'webclient',
  'marketplace',
  'webclient123',
  'demo',
  'authorization_code, refresh_token',
  'https://store-ws.herokuapp.com',
  'APP_CLIENT_OAUTH2',
  180,
  1800,
  NULL,
  FALSE
);

insert into oauth_client_details (
  client_id,
  resource_ids,
  client_secret,
  scope,
  authorized_grant_types,
  web_server_redirect_uri,
  authorities,
  access_token_validity,
  refresh_token_validity,
  additional_information,
  autoapprove ) VALUES (
  'jsclient',
  'marketplace',
  NULL,
  'demo',
  'implicit',
  '',
  'APP_CLIENT_OAUTH2',
  7200,
  0,
  NULL,
  TRUE
);

insert into oauth_client_details (
  client_id,
  resource_ids,
  client_secret,
  scope,
  authorized_grant_types,
  web_server_redirect_uri,
  authorities,
  access_token_validity,
  refresh_token_validity,
  additional_information,
  autoapprove ) VALUES (
  'ownclient',
  'marketplace',
  'ownclient001',
  'full',
  'password',
  '',
  'APP_CLIENT_OAUTH2',
  7200,
  0,
  NULL,
  TRUE
);

insert into oauth_client_details (
  client_id,
  resource_ids,
  client_secret,
  scope,
  authorized_grant_types,
  web_server_redirect_uri,
  authorities,
  access_token_validity,
  refresh_token_validity,
  additional_information,
  autoapprove ) VALUES (
  'appclient',
  'marketplace',
  'appclient001',
  'demo',
  'client_credentials',
  '',
  'APP_CLIENT_OAUTH2',
  7200,
  0,
  NULL,
  TRUE
);

*/