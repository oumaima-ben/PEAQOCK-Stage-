package com.example.kyc.mapper;

import com.example.kyc.entity.ChildrenForm;
import com.example.kyc.entity.ParentForm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Lazy;


@Lazy
@FieldDefaults(level = AccessLevel.PRIVATE)
@Mapper(
       config = SpringMappingConfig.class
)
@RequiredArgsConstructor
public class SharedMapper {
    private ParentForm parentForm;

   /* @BeforeMapping
    public void setChildrenForms(@MappingTarget List<ChildrenForm> childrenForms){
       // this.parentForm = parentForm;
        for (ChildrenForm form : childrenForms) {
            form.setParentForm(this.parentForm);
        }
    }*/
    @AfterMapping
    public void setParentForm(@MappingTarget ParentForm parentForm) {
        for (ChildrenForm childrenForm : parentForm.getChildrenForms()) {
            childrenForm.setParentForm(parentForm);
        }

        //  Optional.ofNullable(this.parentForm.getChildrenForms())
        //        .ifPresent(it -> it.setOrder(order));

        //  Optional.ofNullable(parentForm.getChildrenForms())
        //        .ifPresent(it -> it.forEach(childrenForm -> childrenForm.setParentForm(parentForm)));

    }

}
