package ReflectionAndAnnotation7.Lab.ReflectionAndAnnotation_CreateAnnotationLab04;

//@Target(ElementType.TYPE);
//@Retention(RetentionPolicy.RUNTIME);
public @interface Subject {
    String[] categories() default {};
}