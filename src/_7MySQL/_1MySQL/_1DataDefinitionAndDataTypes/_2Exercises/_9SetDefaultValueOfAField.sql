ALTER TABLE minions.users
CHANGE last_login_time last_login_time DATETIME DEFAULT NOW();