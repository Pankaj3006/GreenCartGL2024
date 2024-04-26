package utils;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DatatableUtils {
    public static List<String> retrieveDataFromDataTableWithHeader(DataTable data) {
        List<Map<String, String>> listOfItems = data.asMaps();
        List<String> listOfItemsNeedsToAdd = new ArrayList<String>();
        Iterator<Map<String, String>> iterator = listOfItems.iterator();
        while (iterator.hasNext()) {
            Map<String, String> items = iterator.next();
            Iterator<Map.Entry<String, String>> itr_entry = items.entrySet().iterator();
            while (itr_entry.hasNext()) {
                Map.Entry<String, String> entry = itr_entry.next();
                listOfItemsNeedsToAdd.add(entry.getValue());
            }
        }
        return listOfItemsNeedsToAdd;
    }

    public static List<String> retrieveDataFromDataTableWithOutOrder(DataTable data) {
        List<List<String>> listOfItems = data.asLists();
        List<String> listOfItemsNeedsToAdd = new ArrayList<String>();
        Iterator<List<String>> iterator = listOfItems.iterator();
        while (iterator.hasNext()) {
            List<String> items = iterator.next();
            Iterator<String> itr_entry = items.iterator();
            while (itr_entry.hasNext()) {
                listOfItemsNeedsToAdd.add(itr_entry.next());
            }
        }
        return listOfItemsNeedsToAdd;
    }
}
