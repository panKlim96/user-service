package contracts.getUserById

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            description("0.0 deleteUserById contract")
            request {
                method POST()
                url("/api/v1/user/deleteUserById/2")
            }
            response {
                status(200)
            }
        }
]
