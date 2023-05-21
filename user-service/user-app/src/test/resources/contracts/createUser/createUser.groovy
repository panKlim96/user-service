package contracts.getUserById

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            description("0.0 createUser contract")
            request {
                method POST()
                url("/api/v1/user/createUser")
                headers {
                    contentType(applicationJson())
                }
                body(file("createUser_request.json"))
            }
            response {
                status(200)
            }
        }
]
