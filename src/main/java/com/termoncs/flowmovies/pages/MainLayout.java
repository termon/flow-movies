package com.termoncs.flowmovies.pages;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

@PWA(name = "Vaadin | Movie Management System", shortName = "MMS", enableInstallPrompt = false)
@Push
@CssImport("./styles/styles.css")
public class MainLayout extends AppLayout {
    public MainLayout() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Vaadin | MMS");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();

        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.add(
                createTab(VaadinIcon.DASHBOARD, "Home", HomeView.class),
                createTab(VaadinIcon.RECORDS, "Movies", MovieListView.class),
                createTab(VaadinIcon.LIST, "ToDo's", ToDoView.class)
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }

    private Tab createTab(VaadinIcon viewIcon, String viewName, Class viewClass) {
        Icon icon = viewIcon.create();
        icon.getStyle()
                .set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-s)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        link.add(icon, new Span(viewName));
        link.setRoute(viewClass);
        link.setTabIndex(-1);
        return new Tab(link);
    }
}

/*
    Optional Layout Using Navbar Only
//*/
//class MainLayoutNav extends AppLayout {
//
//    public MainLayoutNav() {
//        H1 title = new H1("Vaadin || MMS");
//        title.getStyle()
//                .set("font-size", "var(--lumo-font-size-l)")
//                .set("margin-left", "var(--lumo-space-l)");
//
//        Tabs tabs = getTabs();
//
//        addToNavbar(title, tabs);
//    }
//
//    private Tabs getTabs() {
//        Tabs tabs = new Tabs();
//        tabs.getStyle().set("margin", "auto");
//        tabs.getStyle().set("display", "flex");
//        tabs.add(
//                createTab(VaadinIcon.DASHBOARD, "Home", HomeView.class),
//                createTab(VaadinIcon.RECORDS, "Movie", MovieList.class),
//                createTab(VaadinIcon.LIST, "ToDo", ToDoView.class)
//        );
//        return tabs;
//    }
//
//    private Tab createTab(VaadinIcon viewIcon, String viewName, Class viewClass) {
//        RouterLink link = new RouterLink();
//        link.add(viewName);
//        link.setRoute(viewClass);
//        link.setTabIndex(-1);
//        return new Tab(link);
//    }
//}