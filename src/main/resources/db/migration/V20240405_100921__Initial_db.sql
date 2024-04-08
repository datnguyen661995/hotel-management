CREATE TABLE "hotel-management-service".customer (
                                             created_at timestamp(6) NULL,
                                             id bigserial NOT NULL,
                                             updated_at timestamp(6) NULL,
                                             created_by varchar(255) NULL,
                                             email varchar(255) NULL,
                                             "name" varchar(255) NULL,
                                             phone varchar(255) NULL,
                                             updated_by varchar(255) NULL,
                                             CONSTRAINT customer_pkey PRIMARY KEY (id)
);
CREATE TABLE "hotel-management-service".hotel (
                                          rating int4 NOT NULL,
                                          created_at timestamp(6) NULL,
                                          id bigserial NOT NULL,
                                          updated_at timestamp(6) NULL,
                                          address varchar(255) NULL,
                                          city varchar(255) NULL,
                                          country varchar(255) NULL,
                                          created_by varchar(255) NULL,
                                          "name" varchar(255) NULL,
                                          updated_by varchar(255) NULL,
                                          CONSTRAINT hotel_pkey PRIMARY KEY (id)
);
CREATE TABLE "hotel-management-service".room (
                                         capacity int4 NULL,
                                         price numeric(38, 2) NULL,
                                         created_at timestamp(6) NULL,
                                         hotel_id int8 NOT NULL,
                                         id bigserial NOT NULL,
                                         updated_at timestamp(6) NULL,
                                         availability varchar(255) NULL,
                                         created_by varchar(255) NULL,
                                         "type" varchar(255) NULL,
                                         is_delete bool NULL,
                                         updated_by varchar(255) NULL,
                                         CONSTRAINT room_availability_check CHECK (((availability)::text = ANY ((ARRAY['AVAILABLE'::character varying, 'BOOKED'::character varying])::text[]))),
	CONSTRAINT room_pkey PRIMARY KEY (id),
	CONSTRAINT room_type_check CHECK (((type)::text = ANY ((ARRAY['SINGLE'::character varying, 'DOUBLE'::character varying, 'TRIPLE'::character varying, 'QUAD'::character varying, 'QUEEN'::character varying, 'KING'::character varying])::text[])))
);

CREATE TABLE "hotel-management-service".booking (
                                            check_in_date date NULL,
                                            check_out_date date NULL,
                                            is_cancel bool NULL,
                                            total_amount numeric(38, 2) NULL,
                                            created_at timestamp(6) NULL,
                                            customer_id int8 NOT NULL,
                                            id bigserial NOT NULL,
                                            room_id int8 NOT NULL,
                                            updated_at timestamp(6) NULL,
                                            created_by varchar(255) NULL,
                                            status varchar(255) NULL,
                                            updated_by varchar(255) NULL,
                                            CONSTRAINT booking_pkey PRIMARY KEY (id),
                                            CONSTRAINT booking_status_check CHECK (((status)::text = ANY ((ARRAY['CONFIRMED'::character varying, 'CANCELLED'::character varying, 'PENDING'::character varying])::text[])))
);

ALTER TABLE "hotel-management-service".booking
    ADD FOREIGN KEY (customer_id) REFERENCES "hotel-management-service".customer(id);

ALTER TABLE "hotel-management-service".booking
    ADD FOREIGN KEY (room_id) REFERENCES "hotel-management-service".room(id);

ALTER TABLE "hotel-management-service".room
    ADD FOREIGN KEY (hotel_id) REFERENCES "hotel-management-service".hotel(id);