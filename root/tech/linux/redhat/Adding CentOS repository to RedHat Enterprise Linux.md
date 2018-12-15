#Adding CentOS repository to RedHat Enterprise Linux






#this can install gcc and g++   2018.12.14



#http://techsatwork.com/blog/?p=1473


#http://mirror.cisp.com/CentOS/7/os/x86_64/



Adding CentOS repository to RedHat Enterprise Linux
Posted on April 4, 2015 by rpillai

Don’t have an active Red Hat subscription, but you want to use YUM ??? No problem, you can always add CentOS repository to the yum repos directory to have your red hat linux download and install from CentOS repository.
So when trying to install a package using yum, you should be seeing the following message:

[root@localhost ~]# yum install ksh
Loaded plugins: rhnplugin, security
This system is not registered with RHN.
RHN support will be disabled.
Setting up Install Process
No package ksh available.
Nothing to do
[root@localhost ~]#

Here is how :
Edit the file  in vi /etc/yum.repos.d/centos.repo   and add the following lines

[centosrepo]
name=Centos Repository
baseurl=http://mirror.cisp.com/CentOS/6/os/i386/
enabled=1
gpgcheck=1
gpgkey=http://mirror.cisp.com/CentOS/6/os/i386/RPM-GPG-KEY-CentOS-6

Now you should be able to install anything using YUM.  Now try yum install ksh  and it should work.
If you have the server behind a proxy server, then you will need to update /etc/yum.conf and add the following lines :

# The proxy server – proxy server:port number proxy=http://myproxy.mydomain.com:3128         —-> your proxy server and port number 
# The account details for yum connections
proxy_username=yum-user       —->  if you need users and password for your proxy
proxy_password=qwerty            —->  if you need users and password for your proxy
Now yum should be able to go access the centos repository.   As always use this at your own risk.


















