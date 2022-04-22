package com.demo.smartshop.controller;

import com.demo.smartshop.dao.entity.*;
import com.demo.smartshop.dao.enums.Category;
import com.demo.smartshop.dao.enums.OrderStatus;
import com.demo.smartshop.dao.enums.UserRole;
import com.demo.smartshop.service.impl.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class FXMLController implements Initializable {
    private static final java.util.logging.Logger LOG = Logger.getLogger(FXMLController.class.getName());

    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfMidleName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfUserAddress;
    @FXML
    private TextField tfPhone;
    @FXML
    private ComboBox<UserRole> cbUserRole;
    @FXML
    private Button btCreateUser;
    @FXML
    private TextField tfStoreName;
    @FXML
    private TextField tfStoreAddress;
    @FXML
    private ComboBox<UsersEntity> cbStoreOwners;
    @FXML
    private Button btCreateStore;
    @FXML
    private TextField tfProductName;
    @FXML
    private TextField tfProductDescription;
    @FXML
    private TextField tfProductImage;
    @FXML
    private TextField tfProductPrice;
    @FXML
    private ComboBox<Category> cbProductCategory;
    @FXML
    private Button btCreateProduct;
    @FXML
    private ComboBox<UsersEntity> cbUserOrder;
    @FXML
    private ComboBox<ProductEntity> cbOrderProduct;
    @FXML
    private TextField tfOrderQuantity;
    @FXML
    private ComboBox<StoreEntity> cbStoreToSupply;
    @FXML
    private ComboBox<ProductEntity> cbStoreSupplyProduct;
    @FXML
    private TextField tfQuantityToSupply;
    @FXML
    private Button btCreateOrder;
    @FXML
    private Button btSupplyStore;
    @FXML
    private ComboBox<StoreEntity> cbOrderStore;

    @Autowired
    UserEntityService userEntityService;
    @Autowired
    OrderDetailsEntityService orderDetailsEntityService;
    @Autowired
    OrderEntityService orderEntityService;
    @Autowired
    ProductEntityService productEntityService;
    @Autowired
    StoreEntityService storeEntityService;
    @Autowired
    ProductStoreEntityService productStoreEntityService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCheckBoxWithData();
    }

    //Create user
    @FXML
    private void createUser(ActionEvent event) {
        UsersEntity user = readUserForm();
        userEntityService.save(user);
        refresh();
        clearUserDetails();
    }

    void clearUserDetails() {
        tfFirstName.setText("");
        tfMidleName.setText(null);
        tfLastName.setText("");
        tfPassword.setText("");
        tfEmail.setText("");
        tfUserAddress.setText("");
        tfPhone.setText("");
        cbUserRole.setValue(null);
    }

    public UsersEntity readUserForm() {
        UsersEntity user = new UsersEntity();
        user.setUserId(111);
        user.setFirstname(tfFirstName.getText());
        user.setMiddlename(tfMidleName.getText());
        user.setLastname(tfLastName.getText());
        user.setEmail(tfEmail.getText());
        user.setPassword(tfPassword.getText());
        user.setAddress(tfUserAddress.getText());
        user.setPhone(tfPhone.getText());
        user.setCreatedAt(new Date(System.currentTimeMillis()));
        user.setUserRole(cbUserRole.getValue());

        return user;
    }

    //Create StoreEntity
    @FXML
    private void createStore(ActionEvent event) throws SQLException {
        StoreEntity StoreEntity = readStoreEntityForm();
        storeEntityService.save(StoreEntity);
        refresh();
        clearStoreEntityDetails();
    }

    public StoreEntity readStoreEntityForm() throws SQLException {
        StoreEntity StoreEntity = new StoreEntity();
        StoreEntity.setName(tfStoreName.getText());
        StoreEntity.setAddress(tfStoreAddress.getText());
        StoreEntity.setUserId(cbStoreOwners.getValue().getUserId());
        return StoreEntity;
    }

    public void clearStoreEntityDetails() {
        tfStoreName.setText("");
        tfStoreAddress.setText("");
        cbStoreOwners.setValue(null);
    }

    //Create ProductEntity
    @FXML
    private void createProduct(ActionEvent event) {
        ProductEntity ProductEntity = readProductEntityForm();
        productEntityService.save(ProductEntity);
        refresh();
        clearProductEntityDetails();
    }

    private ProductEntity readProductEntityForm() {
        ProductEntity ProductEntity = new ProductEntity();
        ProductEntity.setName(tfProductName.getText());
        ProductEntity.setDescription(tfProductDescription.getText());
        ProductEntity.setCategory(cbProductCategory.getValue());
        ProductEntity.setPrice(Double.parseDouble(tfProductPrice.getText()));
        ProductEntity.setImage(tfProductImage.getText());
        return ProductEntity;
    }

    private void clearProductEntityDetails() {
        tfProductName.setText("");
        tfProductDescription.setText("");
        tfProductPrice.setText("");
        tfProductImage.setText("");
        cbProductCategory.setValue(null);
    }

    //Create order
    @FXML
    private void createOrder(ActionEvent event) {
        OrderEntity order = readOrderForm();
        readOrderDetailsForm(order);
        orderEntityService.save(order);
        orderDetailsEntityService.save(order.getOrderDetailsEntity());
        refresh();
        clearOrderDetails();
    }

    private OrderEntity readOrderForm() {
        OrderEntity order = new OrderEntity();
        order.setUserId(cbUserOrder.getValue().getUserId());

        order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        order.setOrderStatus(OrderStatus.IN_PROCESS);
        order.setShippingAddress(cbUserOrder.getValue().getAddress());
        order.setShippingDate(null);
        order.setTotalCost(cbOrderProduct.getValue().getPrice()
                * Integer.parseInt(tfOrderQuantity.getText()));
        order.setOrderDetailsEntity(
                new OrderDetailsEntity(1,
                        cbOrderProduct.getValue().getProduct_id(),
                        cbOrderStore.getValue().getId(),
                        Integer.parseInt(tfOrderQuantity.getText())
                ));
        return order;
    }

    private OrderDetailsEntity readOrderDetailsForm(OrderEntity orderEntity) {
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setProductId(cbOrderProduct.getValue().getProduct_id());
        orderDetailsEntity.setQuantity(Integer.parseInt(tfOrderQuantity.getText()));
        orderDetailsEntity.setOrderId(orderEntity.getOrderId());
        return orderDetailsEntity;
    }

    private void clearOrderDetails() {
        cbUserOrder.setValue(null);
        cbOrderProduct.setValue(null);
        tfOrderQuantity.setText("");
        cbOrderStore.setValue(null);
    }

    //Supply StoreEntity
    @FXML
    private void supplyStore(ActionEvent event) {
        ProductStoreEntity productStoreEntity = new ProductStoreEntity();
        productStoreEntity.setProductId(cbStoreSupplyProduct.getValue().getProduct_id());
        productStoreEntity.setStoreId(cbStoreToSupply.getValue().getId());


        List<ProductStoreEntity> listOfProductStore = productStoreEntityService.findAll()
                .stream()
                .filter(
                        e ->
                                e.getProductId() == cbStoreSupplyProduct.getValue().getProduct_id() &&
                                        e.getStoreId() == cbStoreToSupply.getValue().getId())
                .collect(Collectors.toList());


        productStoreEntity.setQuantity(Integer.parseInt(tfQuantityToSupply.getText())
                + (listOfProductStore.isEmpty() ? 0 : listOfProductStore.get(0).getQuantity()));

        if (!listOfProductStore.isEmpty()) {
            productStoreEntity.setId(listOfProductStore.get(0).getId());
            productStoreEntityService.update(productStoreEntity);
        } else {
            productStoreEntityService.save(productStoreEntity);
        }

        refresh();
        clearStoreEntitySupplyDetails();
    }

    private void clearStoreEntitySupplyDetails() {
        cbStoreToSupply.setValue(null);
        cbStoreSupplyProduct.setValue(null);
        tfQuantityToSupply.setText("");
    }

    public void fillCheckBoxWithData() {

        //UserRole
        List<UserRole> listOfUserRoleItems = new ArrayList<>();
        for (UserRole userRoleEnum : UserRole.values()) {
            listOfUserRoleItems.add(userRoleEnum);
        }
        cbUserRole.getItems().clear();
        cbUserRole.getItems().addAll(listOfUserRoleItems);

        //User owner
        List<UsersEntity> listOfUser = userEntityService.findAll();
        List<UsersEntity> listOfUserOwners = listOfUser
                .stream()
                .filter(
                        user
                                -> user.getUserRole().getRoleName()
                                .equals(UserRole.SELLER.getRoleName()))
                .collect(Collectors.toList());
        cbStoreOwners.getItems().clear();
        cbStoreOwners.getItems().addAll(listOfUserOwners);

        //ProductEntity
        List<Category> listOfCategoryItems = new ArrayList<>();
        for (Category category : Category.values()) {
            listOfCategoryItems.add(category);
        }
        cbProductCategory.getItems().clear();
        cbProductCategory.getItems().addAll(listOfCategoryItems);

        //Order
        listOfUser = userEntityService.findAll();
        cbUserOrder.getItems().clear();
        cbUserOrder.getItems().addAll(listOfUser);

        List<ProductEntity> listOfProductEntitys;
        listOfProductEntitys = productEntityService.findAll();
        cbOrderProduct.getItems().clear();
        cbOrderProduct.getItems().addAll(listOfProductEntitys);

        List<StoreEntity> listOfOrderStoreEntity;

        listOfOrderStoreEntity = storeEntityService.findAll();
        cbOrderStore.getItems().clear();
        cbOrderStore.getItems().addAll(listOfOrderStoreEntity);

        //Supply StoreEntity
        List<StoreEntity> listOfStoreEntitys;
        listOfStoreEntitys = storeEntityService.findAll();
        cbStoreToSupply.getItems().clear();
        cbStoreToSupply.getItems().addAll(listOfStoreEntitys);

        listOfProductEntitys = productEntityService.findAll();
        cbStoreSupplyProduct.getItems().clear();
        cbStoreSupplyProduct.getItems().addAll(listOfProductEntitys);
    }

    public void refresh() {
        fillCheckBoxWithData();
    }
}
