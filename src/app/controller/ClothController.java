package app.controller;

import app.entity.Cloth;
import app.service.BuilderService;
import app.service.PriceCalculatorService;
import app.view.ClothChoiceView;

import java.util.Map;

public class ClothController {
    ClothChoiceView clothChoiseView = new ClothChoiceView();
    PriceCalculatorService priceCalculatorService = new PriceCalculatorService();

    public void appStart() {
        // Getting Cloth details and save in Map. Can be updated by using dynamic amount of clothes.
        Map<String, String> clothChoise1 = clothChoiseView.getCloth();
        Map<String, String> clothChoise2 = clothChoiseView.getCloth();
        BuilderService clothBuilderService = new BuilderService();
        Cloth cloth1 = clothBuilderService.build(clothChoise1);
        Cloth cloth2 = clothBuilderService.build(clothChoise2);


        double totalPrice = priceCalculatorService.calculatePrice(Double.parseDouble(cloth1.getPrice()), Double.parseDouble(cloth2.getPrice()));
        String result = clothChoiseView.printProducts(cloth1, cloth2, totalPrice);
    }
}
