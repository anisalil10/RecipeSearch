# Recipe Search App

<font color="red">Team Members<font>:
  Aniketh Salil - anisalil10  
  Mallika Singh - ms-2004

## Project Overview
The main function of our app is that it returns recipes catered to a user's preferences. As a group of students originating from a multitude of intersectional identities, we found that the edamame API provided a database of recipes that supported all walks of life. It is difficult to find a centralized recipe search platform that supports the lifestyles of all cultures, which is why we tried to make an app that catered to this niche. A user can input their diet preferences and preferred cuisine to return a list of recipes that fit their needs.

## User Stories  

### Team story - As a user, I want to select certain filters and get recipes aligning with my preferences.
Abigail wants to look for a new recipe. They add filters (such as cuisine, health, ingredients, etc.) and enter a search for what they are looking for. The search returns a list of recipes that fit their needs.
#### Use Cases
 - Be able to enter search parameters like the query, cuisine, and meal type.
 - Return a list of recipes from the API based on search parameters
 - Be able to open each recipe

### Mallika's story - As a frequent user, I want to save recipes that I see and view them later.
Mallika comes across a recipe they really like. They add it to their favourites list so they can find it again. Later, when they are looking for a recipe they remember saving, they open their favourites list and find the recipe they are looking for.
#### Use Cases
- Create a user profile with a unique username that is saved permanently
- Be able to view recipes and their details to save them later
- Open User Profile to access favourites

### Aniketh's story - As a chef, I want to see what recipes are most popular amongst other people.
Aniketh wants to see what recipes are popular amongst other users. They open a global stats page where they view the most popular recipes shown by most favourites given by users. Each recipe displays the number of times it was favoured. They can then further view the most popular in a few broad categories.

# **Recipe Searcher and Viewer**

---

## **Table of Contents**
1. [Authors](#authors)
2. [Summary](#summary)
3. [Features](#features)
4. [Installation Instructions](#installation-instructions)
5. [Usage Guide](#usage-guide)
6. [License](#license)
7. [Feedback](#feedback)
8. [Contributions](#contributions)

---

## **Authors**
- **Team Name**: `errorTeamNameNotFound`
- **Contributors**:
  - Aniketh
  - Mallika

---

## **Summary**

### **What does this project do?**
The **Recipe Searcher and Viewer** is a Java-based application that allows users to search, view, and manage recipes. The program uses filters for preferences like cuisine type, mealtime, and dietary restrictions to provide tailored results. Users can save their favorite recipes and explore popular recipes globally or by category.

### **Why was this project made?**
The program was designed to streamline the recipe discovery process and help users organize and find recipes suited to their specific needs and preferences.

### **What problem does this solve?**
It reduces the time and effort required to find relevant recipes, simplifies meal planning, and provides a convenient way to manage and revisit favorite recipes.

---

## **Features**

1. **Recipe Search**:
  - Search recipes using keywords and filters like cuisine type, meal type, dietary restrictions, and ingredients.

2. **Recipe Viewer**:
  - View recipe details, including:
    - Ingredients.
    - Instructions.
    - Nutritional information.

3. **Favorites Management**:
  - Save recipes to a personal favorites list.
  - View, organize, and revisit favorite recipes.

4. **Global Popular Recipes**:
  - Explore globally popular recipes or filter by specific categories (e.g., cuisine, mealtime).

5. **User Preferences**:
  - Set global preferences for dietary restrictions, favorite cuisines, and excluded ingredients for personalized searches.

### **Screenshots** *(Optional: Include images or GIFs to showcase features)*
![Recipe Search Example](https://via.placeholder.com/400x300)
*An example of the recipe search feature.*

---

## **Installation Instructions**

### **System Requirements**
- **Operating System**: Windows, macOS, or Linux.
- **Java Version**: Java 17 or higher.

### **Dependencies**
1. **Java Swing**: For the graphical user interface.
2. **Gson**: For JSON parsing.
3. **Apache HttpClient**: For API requests.
4. **Edamam Recipe Search API**:
  - [Sign up for an API Key](https://developer.edamam.com/edamam-recipe-api).

### **Steps to Install**
1. **Import the Project**:
- Open the project in your preferred IDE (e.g., IntelliJ IDEA).
2. **Install Required Dependencies**:
- Ensure all necessary libraries (e.g., Gson, Apache HttpClient) are installed in your IDE.
3. **Set Up API Credentials**:
- Create a `.env` file in the root directory and add the following:
  ```bash
  APP_ID=your_app_id
  APP_KEY=your_app_key
  ```
4. **Compile the Project**:
   ```bash
   javac Main/app/ReciperSearchBuilder.java


### **System Requirements**
- **Operating System**: Windows, macOS, or Linux.
- **Java Version**: Java 17 or higher.

# Common Issues and Troubleshooting
# Issue: API Key not working
# Solution: Ensure the APP_ID and APP_KEY in your .env file are valid.

# Issue: ClassNotFoundException for dependencies
# Solution: Confirm all required libraries are installed in your IDE.

# How to Use the Program

# 1. Sign Up or Log In
# Create a profile or log in with existing credentials.

# 2. Search for Recipes
# Use keywords or filters (e.g., cuisine, meal type) to refine your recipe search.

# 3. View Recipe Details
# Click on a recipe to see its ingredients, instructions, and nutritional facts.

# 4. Save Favorites
# Add recipes to your favorites list for easy access later.

# 5. Explore Popular Recipes
# Navigate to the "Popular Recipes" section to see recipes most favored by other users.

# 6. Navigate Between Views
# Use buttons to move seamlessly between the recipe search view, profile view, and favorites list.

# This project is licensed under the MIT License.
# You can view the full license in the LICENSE file.

# We welcome your feedback to improve this project!

# Submit Feedback:
# Open an issue on our GitHub Issues page: https://github.com/errorTeamNameNotFound/recipe-searcher/issues.

# Feedback Guidelines:
# 1. Provide constructive feedback with clear descriptions.
# 2. Include specific details about the issue or feature request.

# How to Contribute

# Step 1: Fork the Repository
# Click "Fork" on the top-right of this page.

# Step 2: Clone Your Fork
git clone https://github.com/yourusername/recipe-searcher.git

# Step 3: Make Changes
# Follow project coding standards.
# Ensure your changes are well-documented.

# Step 4: Submit a Pull Request
# Open a pull request with a clear description of your changes.

# Contribution Guidelines:
# - Write clear and concise commit messages.
# - Ensure code passes all tests before submission.
# - Document all new features and updates thoroughly.

# 1. Add screenshots, videos, or GIFs demonstrating major features.
# 2. Expand troubleshooting examples for common installation or usage issues.
# 3. Update the feedback section with a link to a feedback form if needed.

# 1. Add screenshots, videos, or GIFs demonstrating major features.
# 2. Expand troubleshooting examples for common installation or usage issues.
# 3. Update the feedback section with a link to a feedback form if needed.

