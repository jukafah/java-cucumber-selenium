package cucumber.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class TestData {

    public final User user;

    public TestData(String username) {
        this.user = setUserData(username);
	}

	public class User {
	    public String username;
		public String name;
        public String email;
        public String password;

        String getUsername() { return username; }
        void setUsername(String username) { this.username = username; }
		String getName() { return name; }
		void setName(String name) { this.name = name; }
		String getEmail() { return email; }
		void setEmail(String email) { this.email = email; }
		String getPassword() { return password; }
		void setPassword(String password) { this.password = password; }
	}

	private User setUserData(String username) {

		InputStream file = getClass().getResourceAsStream(String.format("/users/%s.json", username));
		BufferedReader reader = new BufferedReader(new InputStreamReader(file));

		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		JsonElement jsonElement = parser
				.parse(reader)
				.getAsJsonObject();

		return gson.fromJson(jsonElement, User.class);
	}
}