import java.util.*;

/*
 * What you learn from this kata : Follow that Spy (syntax-focused commented):
 *
 * - Map and Set usage:
 *   Map<String, String> for origin → destination relationships
 *   Set<String> to track all destinations and detect the starting point
 *
 * - Looping techniques:
 *   Classic for-loop with index to iterate over arrays
 *   Enhanced for-loop (for-each) to iterate over collections
 *   While-loop to traverse a chained path until reaching null
 *
 * - StringBuilder:
 *   Efficient string concatenation
 *   Use of .append() and .setLength() to format output cleanly
 *
 * - Java syntax patterns:
 *   Variable declaration and initialization
 *   Method structure: public, return type, parameters
 *   Collection methods: .put(), .add(), .get(), .contains()
 *
 * - Algorithmic thinking:
 *   Identifying the starting node by comparing keys and values
 *   Traversing a directed path using chained map lookups
 */

public class Routes {

    public String findRoutes(String[][] routes) {
      
        // Step 1: Convert the array of route pairs into a map: origin → destination
        Map<String, String> routesMap = new HashMap<>();
        
        // Step 2: Collect all destinations into a set for quick lookup
        Set<String> destinies = new HashSet<>();
        
        for (int i = 0; i < routes.length; i++) {
            routesMap.put(routes[i][0], routes[i][1]); // origin → destination
            destinies.add(routes[i][1]);               // store destination
        }
        
        // Step 3: Find the starting point — a city that is never a destination
        String start = null;
        for (String departure : routesMap.keySet()) {
            if (!destinies.contains(departure)) {
                start = departure;
                break; // only one valid starting point
            }
        }
        
        // Step 4: Traverse the route from start to end using the map
        StringBuilder route = new StringBuilder();
        String current = start;

        while (current != null) {
            route.append(current).append(", ");    // add current city
            current = routesMap.get(current);          // move to next city
        }

        // Step 5: Remove the trailing comma and space
        route.setLength(route.length() - 2);
        
        // Step 6: Return the full route as a comma-separated string
        return route.toString();
    }
}
