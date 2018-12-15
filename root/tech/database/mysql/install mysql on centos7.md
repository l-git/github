



#MySQL-5.6.39-1.el6.x86_64.rpm-bundle.tar

tar xvf MySQL-5.6.39-1.el6.x86_64.rpm-bundle.tar


MySQL-client-5.6.39-1.el6.x86_64.rpm
MySQL-devel-5.6.39-1.el6.x86_64.rpm
MySQL-embedded-5.6.39-1.el6.x86_64.rpm
MySQL-server-5.6.39-1.el6.x86_64.rpm
MySQL-shared-5.6.39-1.el6.x86_64.rpm
MySQL-shared-compat-5.6.39-1.el6.x86_64.rpm
MySQL-test-5.6.39-1.el6.x86_64.rpm




# rpm --nodep -e mariadb-libs-5.5.41-2.el7_0.x86_64

# rpm -ihv MySQL-server-5.6.39-1.el6.x86_64.rpm

 
 warning: MySQL-server-5.6.39-1.el6.x86_64.rpm: Header V3 DSA/SHA1 Signature, key ID 5072e1f5: NOKEY
Preparing...                          ################################# [100%]
Updating / installing...
   1:MySQL-server-5.6.39-1.el6        ################################# [100%]
warning: user mysql does not exist - using root
warning: group mysql does not exist - using root
warning: user mysql does not exist - using root
warning: group mysql does not exist - using root
2018-06-06 05:43:47 0 [Warning] TIMESTAMP with implicit DEFAULT value is deprecated. Please use --explicit_defaults_for_timestamp server option (see documentation for more details).
2018-06-06 05:43:47 0 [Note] Ignoring --secure-file-priv value as server is running with --bootstrap.
2018-06-06 05:43:47 0 [Note] /usr/sbin/mysqld (mysqld 5.6.39) starting as process 2857 ...
2018-06-06 05:43:47 2857 [Note] InnoDB: Using atomics to ref count buffer pool pages
2018-06-06 05:43:47 2857 [Note] InnoDB: The InnoDB memory heap is disabled
2018-06-06 05:43:47 2857 [Note] InnoDB: Mutexes and rw_locks use GCC atomic builtins
2018-06-06 05:43:47 2857 [Note] InnoDB: Memory barrier is not used
2018-06-06 05:43:47 2857 [Note] InnoDB: Compressed tables use zlib 1.2.3
2018-06-06 05:43:47 2857 [Note] InnoDB: Using Linux native AIO
2018-06-06 05:43:47 2857 [Note] InnoDB: Using CPU crc32 instructions
2018-06-06 05:43:47 2857 [Note] InnoDB: Initializing buffer pool, size = 128.0M
2018-06-06 05:43:47 2857 [Note] InnoDB: Completed initialization of buffer pool
2018-06-06 05:43:47 2857 [Note] InnoDB: The first specified data file ./ibdata1 did not exist: a new database to be created!
2018-06-06 05:43:47 2857 [Note] InnoDB: Setting file ./ibdata1 size to 12 MB
2018-06-06 05:43:47 2857 [Note] InnoDB: Database physically writes the file full: wait...
2018-06-06 05:43:47 2857 [Note] InnoDB: Setting log file ./ib_logfile101 size to 48 MB
2018-06-06 05:43:48 2857 [Note] InnoDB: Setting log file ./ib_logfile1 size to 48 MB
2018-06-06 05:43:48 2857 [Note] InnoDB: Renaming log file ./ib_logfile101 to ./ib_logfile0
2018-06-06 05:43:48 2857 [Warning] InnoDB: New log files created, LSN=45781
2018-06-06 05:43:48 2857 [Note] InnoDB: Doublewrite buffer not found: creating new
2018-06-06 05:43:48 2857 [Note] InnoDB: Doublewrite buffer created
2018-06-06 05:43:48 2857 [Note] InnoDB: 128 rollback segment(s) are active.
2018-06-06 05:43:48 2857 [Warning] InnoDB: Creating foreign key constraint system tables.
2018-06-06 05:43:48 2857 [Note] InnoDB: Foreign key constraint system tables created
2018-06-06 05:43:48 2857 [Note] InnoDB: Creating tablespace and datafile system tables.
2018-06-06 05:43:48 2857 [Note] InnoDB: Tablespace and datafile system tables created.
2018-06-06 05:43:48 2857 [Note] InnoDB: Waiting for purge to start
2018-06-06 05:43:48 2857 [Note] InnoDB: 5.6.39 started; log sequence number 0
A random root password has been set. You will find it in '/root/.mysql_secret'.
2018-06-06 05:43:48 2857 [Note] Binlog end
2018-06-06 05:43:48 2857 [Note] InnoDB: FTS optimize thread exiting.
2018-06-06 05:43:48 2857 [Note] InnoDB: Starting shutdown...
2018-06-06 05:43:50 2857 [Note] InnoDB: Shutdown completed; log sequence number 1625977


2018-06-06 05:43:50 0 [Warning] TIMESTAMP with implicit DEFAULT value is deprecated. Please use --explicit_defaults_for_timestamp server option (see documentation for more details).
2018-06-06 05:43:50 0 [Note] Ignoring --secure-file-priv value as server is running with --bootstrap.
2018-06-06 05:43:50 0 [Note] /usr/sbin/mysqld (mysqld 5.6.39) starting as process 2879 ...
2018-06-06 05:43:50 2879 [Note] InnoDB: Using atomics to ref count buffer pool pages
2018-06-06 05:43:50 2879 [Note] InnoDB: The InnoDB memory heap is disabled
2018-06-06 05:43:50 2879 [Note] InnoDB: Mutexes and rw_locks use GCC atomic builtins
2018-06-06 05:43:50 2879 [Note] InnoDB: Memory barrier is not used
2018-06-06 05:43:50 2879 [Note] InnoDB: Compressed tables use zlib 1.2.3
2018-06-06 05:43:50 2879 [Note] InnoDB: Using Linux native AIO
2018-06-06 05:43:50 2879 [Note] InnoDB: Using CPU crc32 instructions
2018-06-06 05:43:50 2879 [Note] InnoDB: Initializing buffer pool, size = 128.0M
2018-06-06 05:43:50 2879 [Note] InnoDB: Completed initialization of buffer pool
2018-06-06 05:43:50 2879 [Note] InnoDB: Highest supported file format is Barracuda.
2018-06-06 05:43:50 2879 [Note] InnoDB: 128 rollback segment(s) are active.
2018-06-06 05:43:50 2879 [Note] InnoDB: Waiting for purge to start
2018-06-06 05:43:50 2879 [Note] InnoDB: 5.6.39 started; log sequence number 1625977
2018-06-06 05:43:50 2879 [Note] Binlog end
2018-06-06 05:43:50 2879 [Note] InnoDB: FTS optimize thread exiting.
2018-06-06 05:43:50 2879 [Note] InnoDB: Starting shutdown...
2018-06-06 05:43:52 2879 [Note] InnoDB: Shutdown completed; log sequence number 1625987




A RANDOM PASSWORD HAS BEEN SET FOR THE MySQL root USER !
You will find that password in '/root/.mysql_secret'.

You must change that password on your first connect,
no other statement but 'SET PASSWORD' will be accepted.
See the manual for the semantics of the 'password expired' flag.

Also, the account for the anonymous user has been removed.

In addition, you can run:

  /usr/bin/mysql_secure_installation

which will also give you the option of removing the test database.
This is strongly recommended for production servers.

See the manual for more instructions.

Please report any problems at http://bugs.mysql.com/

The latest information about MySQL is available on the web at

  http://www.mysql.com

Support MySQL by buying support/licenses at http://shop.mysql.com

New default config file was created as /usr/my.cnf and
will be used by default by the server when you start it.
You may edit this file to change server settings




#rpm -ivh MySQL-client-5.6.39-1.el6.x86_64.rpm


warning: MySQL-client-5.6.39-1.el6.x86_64.rpm: Header V3 DSA/SHA1 Signature, key ID 5072e1f5: NOKEY
Preparing...                          ################################# [100%]
Updating / installing...
   1:MySQL-client-5.6.39-1.el6        ################################# [100%]
   
   
 
O67wZf71S2Q6km4y



#systemctl start mysql


root       3766      1  0 06:12 ?        00:00:00 /bin/sh /usr/bin/mysqld_safe --datadir=/var/lib/mysql --pid-file=/var/lib/mysql/localhost.localdomain.pid
mysql      3862   3766  2 06:12 ?        00:00:00 /usr/sbin/mysqld --basedir=/usr --datadir=/var/lib/mysql --plugin-dir=/usr/lib64/mysql/plugin --user=mysql --log-error=localhost.localdomain.err --pid-file=/var/lib/mysql/localhost.localdomain.pid

 
 
#SET PASSWORD ... = PASSWORD('auth_string');
 
 
 
#mysql allow remote connections
 
 
 GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'password' WITH GRANT OPTION;
 FLUSH PRIVILEGES;
 
 
 
 
#create database utf8
 
 CREATE DATABASE a CHARACTER SET utf8 COLLATE utf8_general_ci;
 
 



#install on different location has differnet result


mysql.service - LSB: start and stop MySQL
   Loaded: loaded (/etc/rc.d/init.d/mysql)
   Active: failed (Result: exit-code) since Thu 2018-06-07 18:49:30 PDT; 7min ago
  Process: 3822 ExecStart=/etc/rc.d/init.d/mysql start (code=exited, status=1/FAILURE)

Jun 07 18:49:28 localhost.localdomain systemd[1]: Starting LSB: start and sto...
Jun 07 18:49:30 localhost.localdomain mysql[3822]: Starting MySQL.. ERROR! Th...
Jun 07 18:49:30 localhost.localdomain systemd[1]: mysql.service: control proc...
Jun 07 18:49:30 localhost.localdomain systemd[1]: Failed to start LSB: start ...
Jun 07 18:49:30 localhost.localdomain systemd[1]: Unit mysql.service entered ...
Hint: Some lines were ellipsized, use -l to show in full.
[root@localhost network-scripts]# systemctl start mysql.service
Job for mysql.service failed. See 'systemctl status mysql.service' and 'journalctl -xn' for details.



2018-06-07 19:01:29 4649 [Note] ./mysqld: Shutdown complete

[root@localhost sbin]# ./mysqld --user=root
2018-06-07 19:01:46 0 [Warning] TIMESTAMP with implicit DEFAULT value is deprecated. Please use --explicit_defaults_for_timestamp server option (see documentation for more details).
2018-06-07 19:01:46 0 [Note] ./mysqld (mysqld 5.6.40) starting as process 4658 ...
2018-06-07 19:01:46 4658 [Note] Plugin 'FEDERATED' is disabled.
./mysqld: Table 'mysql.plugin' doesn't exist
2018-06-07 19:01:46 4658 [ERROR] Can't open the mysql.plugin table. Please run mysql_upgrade to create it.
2018-06-07 19:01:46 4658 [Note] InnoDB: Using atomics to ref count buffer pool pages
2018-06-07 19:01:46 4658 [Note] InnoDB: The InnoDB memory heap is disabled
2018-06-07 19:01:46 4658 [Note] InnoDB: Mutexes and rw_locks use GCC atomic builtins
2018-06-07 19:01:46 4658 [Note] InnoDB: Memory barrier is not used
2018-06-07 19:01:46 4658 [Note] InnoDB: Compressed tables use zlib 1.2.3
2018-06-07 19:01:46 4658 [Note] InnoDB: Using Linux native AIO
2018-06-07 19:01:46 4658 [Note] InnoDB: Using CPU crc32 instructions
2018-06-07 19:01:46 4658 [Note] InnoDB: Initializing buffer pool, size = 128.0M
2018-06-07 19:01:46 4658 [Note] InnoDB: Completed initialization of buffer pool
2018-06-07 19:01:46 4658 [Note] InnoDB: Highest supported file format is Barracuda.
2018-06-07 19:01:46 4658 [Note] InnoDB: Log scan progressed past the checkpoint lsn 49463
2018-06-07 19:01:46 4658 [Note] InnoDB: Database was not shutdown normally!
2018-06-07 19:01:46 4658 [Note] InnoDB: Starting crash recovery.
2018-06-07 19:01:46 4658 [Note] InnoDB: Reading tablespace information from the .ibd files...
2018-06-07 19:01:46 4658 [Note] InnoDB: Restoring possible half-written data pages
2018-06-07 19:01:46 4658 [Note] InnoDB: from the doublewrite buffer...
InnoDB: Doing recovery: scanned up to log sequence number 1600607
2018-06-07 19:01:46 4658 [Note] InnoDB: Starting an apply batch of log records to the database...
InnoDB: Progress in percent: 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99
InnoDB: Apply batch completed
2018-06-07 19:01:47 4658 [Note] InnoDB: 128 rollback segment(s) are active.
2018-06-07 19:01:47 4658 [Note] InnoDB: Waiting for purge to start
2018-06-07 19:01:47 4658 [Note] InnoDB: 5.6.40 started; log sequence number 1600607
2018-06-07 19:01:47 4658 [Note] Server hostname (bind-address): '*'; port: 3306
2018-06-07 19:01:47 4658 [Note] IPv6 is available.
2018-06-07 19:01:47 4658 [Note]   - '::' resolves to '::';
2018-06-07 19:01:47 4658 [Note] Server socket created on IP: '::'.
2018-06-07 19:01:47 4658 [ERROR] Fatal error: Can't open and lock privilege tables: Table 'mysql.user' doesn't exist


 
 
 https://serverfault.com/questions/291126/mysql-fatal-error-cant-open-and-lock-privilege-tables-table-mysql-host-doe



[root@localhost sbin]# mysql_install_db
Installing MySQL system tables...2018-06-07 19:04:41 0 [Warning] TIMESTAMP with implicit DEFAULT value is deprecated. Please use --explicit_defaults_for_timestamp server option (see documentation for more details).
2018-06-07 19:04:41 0 [Note] Ignoring --secure-file-priv value as server is running with --bootstrap.
2018-06-07 19:04:41 0 [Note] /usr/sbin/mysqld (mysqld 5.6.40) starting as process 4710 ...
2018-06-07 19:04:41 4710 [Note] InnoDB: Using atomics to ref count buffer pool pages
2018-06-07 19:04:41 4710 [Note] InnoDB: The InnoDB memory heap is disabled
2018-06-07 19:04:41 4710 [Note] InnoDB: Mutexes and rw_locks use GCC atomic builtins
2018-06-07 19:04:41 4710 [Note] InnoDB: Memory barrier is not used
2018-06-07 19:04:41 4710 [Note] InnoDB: Compressed tables use zlib 1.2.3
2018-06-07 19:04:41 4710 [Note] InnoDB: Using Linux native AIO
2018-06-07 19:04:41 4710 [Note] InnoDB: Using CPU crc32 instructions
2018-06-07 19:04:41 4710 [Note] InnoDB: Initializing buffer pool, size = 128.0M
2018-06-07 19:04:41 4710 [Note] InnoDB: Completed initialization of buffer pool
2018-06-07 19:04:41 4710 [Note] InnoDB: Highest supported file format is Barracuda.
2018-06-07 19:04:41 4710 [Note] InnoDB: Log scan progressed past the checkpoint lsn 49463
2018-06-07 19:04:41 4710 [Note] InnoDB: Database was not shutdown normally!
2018-06-07 19:04:41 4710 [Note] InnoDB: Starting crash recovery.
2018-06-07 19:04:41 4710 [Note] InnoDB: Reading tablespace information from the .ibd files...
2018-06-07 19:04:41 4710 [Note] InnoDB: Restoring possible half-written data pages
2018-06-07 19:04:41 4710 [Note] InnoDB: from the doublewrite buffer...
InnoDB: Doing recovery: scanned up to log sequence number 1600607
2018-06-07 19:04:41 4710 [Note] InnoDB: Starting an apply batch of log records to the database...
InnoDB: Progress in percent: 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99
InnoDB: Apply batch completed
2018-06-07 19:04:42 4710 [Note] InnoDB: 128 rollback segment(s) are active.
2018-06-07 19:04:42 4710 [Note] InnoDB: Waiting for purge to start
2018-06-07 19:04:42 4710 [Note] InnoDB: 5.6.40 started; log sequence number 1600607
2018-06-07 19:04:42 4710 [Note] Binlog end
2018-06-07 19:04:42 4710 [Note] InnoDB: FTS optimize thread exiting.
2018-06-07 19:04:42 4710 [Note] InnoDB: Starting shutdown...
2018-06-07 19:04:44 4710 [Note] InnoDB: Shutdown completed; log sequence number 1625987
OK

Filling help tables...2018-06-07 19:04:44 0 [Warning] TIMESTAMP with implicit DEFAULT value is deprecated. Please use --explicit_defaults_for_timestamp server option (see documentation for more details).
2018-06-07 19:04:44 0 [Note] Ignoring --secure-file-priv value as server is running with --bootstrap.
2018-06-07 19:04:44 0 [Note] /usr/sbin/mysqld (mysqld 5.6.40) starting as process 4734 ...
2018-06-07 19:04:44 4734 [Note] InnoDB: Using atomics to ref count buffer pool pages
2018-06-07 19:04:44 4734 [Note] InnoDB: The InnoDB memory heap is disabled
2018-06-07 19:04:44 4734 [Note] InnoDB: Mutexes and rw_locks use GCC atomic builtins
2018-06-07 19:04:44 4734 [Note] InnoDB: Memory barrier is not used
2018-06-07 19:04:44 4734 [Note] InnoDB: Compressed tables use zlib 1.2.3
2018-06-07 19:04:44 4734 [Note] InnoDB: Using Linux native AIO
2018-06-07 19:04:44 4734 [Note] InnoDB: Using CPU crc32 instructions
2018-06-07 19:04:44 4734 [Note] InnoDB: Initializing buffer pool, size = 128.0M
2018-06-07 19:04:44 4734 [Note] InnoDB: Completed initialization of buffer pool
2018-06-07 19:04:44 4734 [Note] InnoDB: Highest supported file format is Barracuda.
2018-06-07 19:04:44 4734 [Note] InnoDB: 128 rollback segment(s) are active.
2018-06-07 19:04:44 4734 [Note] InnoDB: Waiting for purge to start
2018-06-07 19:04:44 4734 [Note] InnoDB: 5.6.40 started; log sequence number 1625987
2018-06-07 19:04:44 4734 [Note] Binlog end
2018-06-07 19:04:44 4734 [Note] InnoDB: FTS optimize thread exiting.
2018-06-07 19:04:44 4734 [Note] InnoDB: Starting shutdown...
2018-06-07 19:04:46 4734 [Note] InnoDB: Shutdown completed; log sequence number 1625997
OK

To start mysqld at boot time you have to copy
support-files/mysql.server to the right place for your system

PLEASE REMEMBER TO SET A PASSWORD FOR THE MySQL root USER !
To do so, start the server, then issue the following commands:

  /usr/bin/mysqladmin -u root password 'new-password'
  /usr/bin/mysqladmin -u root -h localhost.localdomain password 'new-password'

Alternatively you can run:

  /usr/bin/mysql_secure_installation

which will also give you the option of removing the test
databases and anonymous user created by default.  This is
strongly recommended for production servers.

See the manual for more instructions.

You can start the MySQL daemon with:

  cd /usr ; /usr/bin/mysqld_safe &

You can test the MySQL daemon with mysql-test-run.pl

  cd mysql-test ; perl mysql-test-run.pl

Please report any problems at http://bugs.mysql.com/

The latest information about MySQL is available on the web at

  http://www.mysql.com

Support MySQL by buying support/licenses at http://shop.mysql.com

New default config file was created as /usr/my.cnf and
will be used by default by the server when you start it.
You may edit this file to change server settings
