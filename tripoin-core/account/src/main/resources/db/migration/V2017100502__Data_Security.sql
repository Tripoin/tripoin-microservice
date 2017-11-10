INSERT INTO s_permission (id, permission_label, permission_value) VALUES
  ('configuresystem', 'CONFIGURE_SYSTEM', 'Configure System'),
  ('editproduct', 'EDIT_PRODUCT', 'Edit Product'),
  ('viewproduct', 'VIEW_PRODUCT', 'View Product');

INSERT INTO s_role (id, description, name) VALUES
  ('superuser', 'SUPERUSER', 'Super User'),
  ('staff', 'STAFF', 'Staff'),
  ('manager', 'MANAGER', 'Manager');

INSERT INTO s_role_permission (id_role, id_permission) VALUES
  ('staff', 'viewproduct'),
  ('manager', 'viewproduct'),
  ('manager', 'editproduct'),
  ('superuser', 'viewproduct'),
  ('superuser', 'editproduct'),
  ('superuser', 'configuresystem');

INSERT INTO s_user (id, active, username, id_role) VALUES
  ('staff', true,'staff', 'staff');

INSERT INTO s_user_password (id_user, password) VALUES
  -- password : CfZKBe7IZHxBCgH9Dz49
  ('staff', '$2a$13$WlKVWzXzLLFi5bCRQJ6Ao.oDh61Ptm/ePWb8Y6E3fkxet/Q2.VEi.');
