package com.codeup.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class DiceController {

@GetMapping("/dice-roll")
    public String diceRoll(Model viewModel){
    ArrayList<Integer> dice = new ArrayList<>();
    for(int i = 1; i<=6; i++){
        dice.add(i);
    }

    viewModel.addAttribute("dice", dice);
        return "dice-roll";
    }
@GetMapping("/dice-roll/{number}")
    public String diceRollResolution(@PathVariable Integer number, Model viewModel){
    viewModel.addAttribute("number", number);
    int rolledDie = (int)(Math.random()* 6 +1);
    viewModel.addAttribute("dieRoll", rolledDie);
    boolean dieMatchesGuess;
    if (number == rolledDie){
        dieMatchesGuess = true;
    }else{
        dieMatchesGuess = false;
    }
    viewModel.addAttribute("dieMatchesGuess", dieMatchesGuess);

    return "dice-roll-end";
}
}
