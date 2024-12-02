package com.bluemoon.api;

import com.bluemoon.manager.HouseholdManager;
import com.bluemoon.model.Household;

import java.util.List;

public class HouseholdAPI {
    private HouseholdManager householdManager;

    public HouseholdAPI() {
        this.householdManager = new HouseholdManager();
    }

    public List<Household> getAllHouseholds() {
        return householdManager.getAllHouseholds();
    }

    public void addHousehold(Household household) {
        householdManager.addHousehold(household);
    }

    public void updateHousehold(Household household) {
        householdManager.updateHousehold(household);
    }

    public void deleteHousehold(String householdId) {
        householdManager.deleteHousehold(householdId);
    }
}