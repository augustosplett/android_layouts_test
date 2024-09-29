# Objective:

The objective of this assignment is to review and practice implementing all the UI components, layouts, and resources that we have covered so far. You will create a multi-page Android app that demonstrates a variety of UI elements, layouts, and resources across different pages. Each page should focus on specific elements, and the app should follow good design practices, such as resource management, layouts, and theme customization.

# Assignment Overview:

You will create an Android app named UIShowcaseApp that consists of multiple pages (activities or fragments). Each page will showcase a different layout and set of UI components. The app should be fully navigable and include a mix of static and dynamic data.

# Requirements:

    App Structure:
        The app must have at least 4 pages (you can use activities or fragments).
        A Navigation Drawer or Bottom Navigation should be used to switch between pages.
        Each page should focus on demonstrating specific UI components and layouts.
        Use resources (strings, colors, dimensions, and images) from the res/ directory for all static data and values.

    Page 1: LinearLayout Demo
        This page should demonstrate the use of LinearLayout (both vertical and horizontal orientations).
        Include the following elements:
            TextView to display static text.
            EditText for user input.
            Button that triggers a simple action (e.g., showing a Toast message).
            ImageView to display an image from the resources.
        Use string resources for all text content.

    Page 2: ConstraintLayout Demo
        This page should demonstrate the use of ConstraintLayout for creating a responsive layout.
        Include the following elements:
            Switch to toggle a setting (with labels for "On" and "Off").
            ProgressBar to represent loading or progress.
            FloatingActionButton (FAB) that triggers an action (e.g., opening a Snackbar).
        Customize the background color and icons using color resources and drawable resources.

    Page 3: Grid Layout Demo
        This page should demonstrate the use of GridView or GridLayout.
        Include a grid that displays at least 6 items, such as images or icons with text labels.
            Each item should be clickable, and when clicked, it should show a Toast with the item's name.
            Use string resources for the labels.
            Use drawable resources for the images or icons.

    Page 4: List Layout Demo
        This page should demonstrate the use of ListView or RecyclerView.
        Populate the list with at least 10 items (e.g., names of countries, cities, or any category).
            Each item should have a clickable Button or Switch that toggles the item's status.
            When an item is clicked, display a Toast message showing its name or status.
            Use custom layout items for each row (e.g., a TextView with a Switch or Button).

    Resource Management:
        Use string resources for all static text (e.g., labels, titles).
        Use color resources for all background colors, text colors, and button colors.
        Use dimension resources for margins, padding, and text sizes.
        Add images or icons in the drawable folder and use them in your layouts (e.g., for the ImageView or GridView items).

    Navigation Between Pages:
        Implement a Navigation Drawer or Bottom Navigation to switch between the pages.
        Ensure each page is clearly labeled in the navigation menu.
        Use FragmentTransaction to manage navigation between fragments if you use fragments, or use Intent for activity switching.

    Bonus (Optional):
        Add day and night themes using theme resources (e.g., use different colors for the night mode).
        Add Localization: Provide translations for the strings in at least one additional language (e.g., French or Spanish).
