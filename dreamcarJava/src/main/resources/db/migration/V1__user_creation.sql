CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(50),
    email VARCHAR(50),

    PRIMARY KEY (id)
);


CREATE TABLE component_requests (
                       id_req BIGINT NOT NULL AUTO_INCREMENT,
                       component_name VARCHAR(50) NOT NULL,
                       quantity INT NOT NULL,
                       target_price INT NOT NULL,
                       limit_time DATE NOT NULL,
                       id_winner BIGINT,
                       is_closed BOOLEAN,

                       PRIMARY KEY (id_req)
);

CREATE TABLE bids (
                      id_bid BIGINT NOT NULL AUTO_INCREMENT,
                      id_user BIGINT NOT NULL,
                      bid_price INT NOT NULL,
                      id_comp_req BIGINT NOT NULL,


                      PRIMARY KEY (id_bid),
                      FOREIGN KEY (id_comp_req) references component_requests (id_req),
                      FOREIGN KEY (id_user) references users (id)
);
