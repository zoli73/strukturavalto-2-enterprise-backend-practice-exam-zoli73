CALL docker build -t train -f Dockerfile .
CALL docker run --name train -p 8080:8080 -d --rm train