package contracts.getUserById

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            description("0.0 createUser contract")
            request {
                method POST()
                url("/api/v1/user/getUserByCriteriaFilter")
                headers {
                    contentType(applicationJson())
                }
                body(file("getUserByCriteriaFilter_likeEmail_Rq.json"))
            }
            response {
                status(200)
                body(file("getUserByCriteriaFilter_likeEmail_Rs.json"))
            }
        }
]
