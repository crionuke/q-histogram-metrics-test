# q-histogram-metrics-test

- Run it in dev mode `./mvnw quarkus:dev`
- Request endpoint by `curl localhost:8080/hello` multiple times
- Open Grafana via `http://localhost:<port>`
- Explore metric `hello_milliseconds_bucket` (all values are in `le="+Inf"`):
  `hello_milliseconds_bucket{class="org.acme.GreetingService",exception="none",job="q-histogram-metrics-test",le="+Inf",method="hello",service_name="q-histogram-metrics-test",service_version="1.0.0-SNAPSHOT"}`

But the same metric comes from the prometheus endpoint looks good (`curl localhost:8080/q/metrics | grep hello`):
`
hello_seconds_bucket{class="org.acme.GreetingService",exception="none",method="hello",le="0.536870911"} 1.0
hello_seconds_bucket{class="org.acme.GreetingService",exception="none",method="hello",le="0.626349396"} 3.0
hello_seconds_bucket{class="org.acme.GreetingService",exception="none",method="hello",le="0.715827881"} 4.0
hello_seconds_bucket{class="org.acme.GreetingService",exception="none",method="hello",le="0.805306366"} 4.0
hello_seconds_bucket{class="org.acme.GreetingService",exception="none",method="hello",le="0.894784851"} 4.0
hello_seconds_bucket{class="org.acme.GreetingService",exception="none",method="hello",le="0.984263336"} 5.0
hello_seconds_bucket{class="org.acme.GreetingService",exception="none",method="hello",le="1.073741824"} 5.0
`


