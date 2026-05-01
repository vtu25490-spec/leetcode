import java.util.*;

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Graph for emails
        Map<String, Set<String>> graph = new HashMap<>();

        // Email -> Name mapping
        Map<String, String> emailToName = new HashMap<>();

        // Build graph
        for (List<String> account : accounts) {

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                emailToName.put(email, name);

                graph.putIfAbsent(email, new HashSet<>());

                // Connect first email with all others
                if (i == 1) {
                    continue;
                }

                String firstEmail = account.get(1);

                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        Set<String> visited = new HashSet<>();

        List<List<String>> result = new ArrayList<>();

        // DFS for connected components
        for (String email : graph.keySet()) {

            if (!visited.contains(email)) {

                List<String> mergedEmails =
                        new ArrayList<>();

                dfs(email, graph, visited, mergedEmails);

                Collections.sort(mergedEmails);

                // Add name at first position
                mergedEmails.add(0,
                        emailToName.get(email));

                result.add(mergedEmails);
            }
        }

        return result;
    }

    private void dfs(String email,
                     Map<String, Set<String>> graph,
                     Set<String> visited,
                     List<String> mergedEmails) {

        visited.add(email);

        mergedEmails.add(email);

        for (String neighbor : graph.get(email)) {

            if (!visited.contains(neighbor)) {

                dfs(neighbor,
                    graph,
                    visited,
                    mergedEmails);
            }
        }
    }
}