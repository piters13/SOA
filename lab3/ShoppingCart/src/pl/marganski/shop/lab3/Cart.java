package pl.marganski.shop.lab3;

import java.util.HashMap;

public class Cart {

	HashMap<Integer, Integer> cart = new HashMap<>();

	public void addProduct(int id) {
		if (cart.containsKey(id)) {
			int amount = cart.get(id);
			cart.put(id, amount + 1);
		} else {
			cart.put(id, 1);
		}
	}

	public void removeFromCart(int id) {
		if (cart.containsKey(id)) {
			cart.remove(id);
		} else {
			return;
		}
	}

	public int getAmount(int id) {
		if (cart.get(id) != null) {
			return cart.get(id);
		} else {
			return 0;
		}
	}

	public int getTotalAmount() {
		return cart.size();
	}
}
