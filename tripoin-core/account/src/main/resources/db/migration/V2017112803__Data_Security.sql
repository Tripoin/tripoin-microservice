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
  ('staff', true,'staff', 'staff'),
  ('manager', true,'manager', 'manager');

INSERT INTO s_user_password (id_user, password) VALUES
  -- password : staff -> balicamp123, manager -> manager menggunakan BCryptPasswordEncoder
  ('staff', '$2a$10$mWAbi9UrOGaYK8mWNexZ7OfNM8BBaoO.eLGAn/PYnRyXdm/HHt8AW'),
  ('manager', '$2a$10$xsFqMz6AO8UPbsa56bE3Ye9s5abEiXmj2JUGi97rNxpfnoHWCPCNy');