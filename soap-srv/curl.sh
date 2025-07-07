



if [ -z "$1" ]; then
  echo "Usage: $0 <port>"
  exit 1
fi


curl -v  --header "content-type: text/xml" -d @request.xml http://localhost:$1/ws




