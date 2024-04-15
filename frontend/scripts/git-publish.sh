git pull
git add -A
git commit -m "build: 升级底包"
git push
git checkout publish
git pull
git merge master
git push
git checkout master