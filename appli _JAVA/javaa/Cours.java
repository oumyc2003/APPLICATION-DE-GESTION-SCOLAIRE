package javaa;

public class Cours {
        private String coursId;
        private String coursName;
        private String description ;

    
        public Cours(String coursId, String coursName) {
            this.coursId = coursId;
            this.coursName = coursName;
        }
    
        public String getCoursId() {
            return coursId;
        }
    
        public String getCoursName() {
            return coursName;
        }
        
        
        public String getDescription() {
                return description;
            }
}
