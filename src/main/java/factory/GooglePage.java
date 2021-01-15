package factory;

public abstract class GooglePage {
    public abstract void launchSite();

    public abstract void search(String keyword);

    public abstract void clickSearchButton();

    public abstract int getResultCount();

    public abstract String getTotalResult();
}
