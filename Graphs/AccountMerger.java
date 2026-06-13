import java.util.*;

public class AccountMerger {
  class UnionFind {
    Map<String, String> parent = new HashMap<>();

    public String find(String x) {
      if (!parent.get(x).equals(x)) {
        parent.put(x, find(parent.get(x)));
      }
      return parent.get(x);
    }

    public void union(String x, String y) {
      String pX = find(x);
      String pY = find(y);
      if (!pX.equals(pY)) {
        parent.put(pX, pY);
      }
    }
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    UnionFind uf = new UnionFind();
    Map<String, String> emailToName = new HashMap<>();
    for (List<String> account : accounts) {
      String name = account.get(0);
      String firstEmail = account.get(1);
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        emailToName.put(email, name);
        uf.parent.putIfAbsent(email, email);
      }
      for (int i = 2; i < account.size(); i++) {
        uf.union(firstEmail, account.get(i));
      }
    }

    Map<String, List<String>> group = new HashMap<>();
    for (String email : emailToName.keySet()) {
      String root = uf.find(email);
      group.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
    }

    List<List<String>> result = new ArrayList<>();
    for (String root : group.keySet()) {
      List<String> emails = group.get(root);
      Collections.sort(emails);

      List<String> mergedAccount = new ArrayList<>();
      mergedAccount.add(emailToName.get(root));
      mergedAccount.addAll(emails);
      result.add(mergedAccount);
    }
    return result;
  }
}
