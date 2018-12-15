find process current work directory

https://unix.stackexchange.com/questions/94357/find-out-current-working-directory-of-a-running-process

lsof -p <PID> | grep cwd

$ pwdx <PID>
lsof
$ lsof -p <PID> | grep cwd
/proc
$ readlink -e /proc/<PID>/cwd











