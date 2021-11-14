package hu.elte.bankapp.webdomain;

public class ForgotView {
        private String username;

        public ForgotView() { }

        public ForgotView(String username) {
            this.username = username;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    @Override
    public String toString() {
        return "ForgotView{" +
                "username='" + username + '\'' +
                '}';
    }
}

