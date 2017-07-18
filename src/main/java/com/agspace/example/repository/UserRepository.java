package com.agspace.example.repository;

import com.agspace.example.entity.User;
//import com.vividsolutions.jts.geom.GeometryFactory;
//import com.vividsolutions.jts.geom.PrecisionModel;
//import com.vividsolutions.jts.io.ParseException;
//import com.vividsolutions.jts.io.WKTReader;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {
//    String polygon = "POLYGON((0 0, 0 1, 1 1, 1 0, 0 0))";
    public User getUser() {
//        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
//        WKTReader reader = new WKTReader(geometryFactory);

        User user = new User();
        user.setName("Bob");

//        try {
//            user.setLocation(reader.read(polygon));
//        } catch (ParseException p) {
//            System.out.print(p.getMessage());
//        }
        return user;

    }
}
