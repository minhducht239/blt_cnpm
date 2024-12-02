package com.bluemoon.api;

import com.bluemoon.manager.UtilityManager;
import com.bluemoon.model.Utility;

import java.util.List;

public class UtilityAPI {
    private UtilityManager utilityManager;

    public UtilityAPI() {
        this.utilityManager = new UtilityManager();
    }

    public List<Utility> getAllUtilities() {
        return utilityManager.getAllUtilities();
    }

    public void addUtility(Utility utility) {
        utilityManager.addUtility(utility);
    }

    public void updateUtility(Utility utility) {
        utilityManager.updateUtility(utility);
    }

    public void deleteUtility(String utilityId) {
        utilityManager.deleteUtility(utilityId);
    }
}