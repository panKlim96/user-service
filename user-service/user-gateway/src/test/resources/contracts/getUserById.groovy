package contracts.getUserById

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            description("0.0 getUserById contract")
                request {
                        method GET()
                        url("/user/gateway/getUserById/6")
                }
                response {
                        status(200)
                        body(file("getUserById_response.json"))
                    headers {
                        contentType(applicationJson())
                    }
                }
        }
]
