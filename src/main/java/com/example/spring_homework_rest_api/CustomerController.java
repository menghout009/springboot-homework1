package com.example.spring_homework_rest_api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
@RestController
public class CustomerController {

    Integer id =5;
    ArrayList<Customer> customers = new ArrayList<>();
    public CustomerController(){
        customers.add(new Customer(1,"mama","male",22,"Cambodia"));
        customers.add(new Customer(2,"messi","male",32,"Argentina"));
        customers.add(new Customer(3,"ronaldo","male",34,"Portugal"));
        customers.add(new Customer(4,"gin","male",16,"Usa"));
    }
// View all customer
    @GetMapping("/api/v1")
    public ResponseEntity<?> customersData(){
        return ResponseEntity.ok(new CustomerResponse<>(
                LocalDateTime.now(),
                "OK",
                "This record has found successfully",
                customers
                ));
    }
//    insert customer
    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(customerRequest.getName());
        customer.setGender(customerRequest.getGender());
        customer.setAge(customerRequest.getAge());
        customer.setAddress(customerRequest.getAddress());
        customers.add(customer);
        return ResponseEntity.ok(new CustomerResponse<>(
                LocalDateTime.now(),
                "OK",
                "This record was successfully created",
                customer
        ));
    }
//    View customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById (@PathVariable Integer id) {
        for (Customer getCustomer : customers) {
            if (getCustomer.getId().equals(id)) {
                return ResponseEntity.ok(new CustomerResponse<>(
                        LocalDateTime.now(),
                        "OK",
                        "Successfully get data",
                        getCustomer
                ));
            }
        }
        return null;
    }
//    find customer by name
    @GetMapping ("/customers/search")
        public ResponseEntity<?> searchNameCustomer(@RequestParam String name){
            for (Customer customerSearch: customers ){
                if(customerSearch.getName().equals(name)){
                    return ResponseEntity.ok(new CustomerResponse<>(
                            LocalDateTime.now(),
                            "OK",
                            "You're search successfully",
                            customerSearch
                    ));
                }
            }
         return null ;
        }
//        Update customer by id
        @PutMapping("customers/update/{id}")
            public ResponseEntity<?> updateNameCustomer(@PathVariable Integer id, @RequestBody Customer customer){
                for (Customer updateNameCustomer : customers){
                    if(updateNameCustomer.getId().equals(id)){
                        updateNameCustomer.setId(customer.getId());
                        updateNameCustomer.setName(customer.getName());
                        updateNameCustomer.setAge(customer.getAge());
                        updateNameCustomer.setAddress(customer.getAddress());
                        return ResponseEntity.ok(new CustomerResponse<>(
                                LocalDateTime.now(),
                                "OK",
                                "You're update successfully",
                                updateNameCustomer));
                    }
                }
            return null;
        }

//        Delete customer by id
        @DeleteMapping("customers/delete/{id}")
            public  ResponseEntity<?> deleteNameCustomer(@PathVariable Integer id){
                for (Customer deleteNameCustomer : customers) {
                        if (deleteNameCustomer.getId().equals(id)) {
                            customers.remove(deleteNameCustomer);
                            return ResponseEntity.ok(new CustomerResponse(
                                    LocalDateTime.now(),
                                    "OK",
                                    "You're deleted successfully",
                                    deleteNameCustomer));
                        }
                    }
                return null;
        }
    }




