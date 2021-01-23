package com.github.johnmcguinness.exampleuicomponents.ui;

import java.util.List;

import com.github.johnmcguinness.exampleuicomponents.util.SecurityUtils;
import com.github.bordertech.wcomponents.Action;
import com.github.bordertech.wcomponents.ActionEvent;
import com.github.bordertech.wcomponents.Size;
import com.github.bordertech.wcomponents.WMessages;
import com.github.bordertech.wcomponents.WPanel;
import com.github.bordertech.wcomponents.validation.Diagnostic;
import com.github.bordertech.wcomponents.validation.ValidatingAction;
import com.github.johnmcguinness.wcomponents.ui.HAlign;
import com.github.johnmcguinness.wcomponents.ui.Ref;
import com.github.johnmcguinness.wcomponents.ui.component.Button;
import static com.github.johnmcguinness.wcomponents.ui.component.Button.button;
import com.github.johnmcguinness.wcomponents.ui.component.PasswordInput;
import com.github.johnmcguinness.wcomponents.ui.component.TextInput;
import static com.github.johnmcguinness.wcomponents.ui.component.Field.field;
import static com.github.johnmcguinness.wcomponents.ui.component.FieldLayout.fieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;
import static com.github.johnmcguinness.wcomponents.ui.component.FieldSet.fieldset;
import static com.github.johnmcguinness.wcomponents.ui.component.Panel.panel;
import static com.github.johnmcguinness.wcomponents.ui.component.TextInput.textInput;
import static com.github.johnmcguinness.wcomponents.ui.component.PasswordInput.passwordInput;
import com.github.johnmcguinness.wcomponents.ui.component.Section;
import static com.github.johnmcguinness.wcomponents.ui.component.Section.section;
import static com.github.johnmcguinness.wcomponents.ui.property.ChildrenProperty.children;
import static com.github.johnmcguinness.wcomponents.ui.property.FieldsProperty.fields;
import static com.github.johnmcguinness.wcomponents.ui.property.FrameTypeProperty.frameType;
import static com.github.johnmcguinness.wcomponents.ui.property.LabelWidthProperty.labelWidth;
import static com.github.johnmcguinness.wcomponents.ui.property.LayoutProperty.flowLayout;
import static com.github.johnmcguinness.wcomponents.ui.property.LayoutProperty.verticalLayout;
import static com.github.johnmcguinness.wcomponents.ui.property.MandatoryProperty.mandatory;
import static com.github.johnmcguinness.wcomponents.ui.property.MarginProperty.margin;
import static com.github.johnmcguinness.wcomponents.ui.property.ReferenceProperty.ref;
import static com.github.johnmcguinness.wcomponents.ui.property.TextProperty.text;
import static com.github.johnmcguinness.wcomponents.ui.property.TitleProperty.title;

/**
 * An example application entry/login screen.
 */
public class LoginScreen extends WPanel
{
    /** The field used to enter in the user id. */
	private final Ref<TextInput> refUserId
		= Ref.create();
		
    /** The field used to enter in the password. */
    private final Ref<PasswordInput> refPasswordField
		= Ref.create();
	
	/** The button to invoke the login action*/
	private final Ref<Button> refLoginButton
		= Ref.create();

	private final Section section
		= section(
			verticalLayout(Size.MEDIUM),
			margin(Size.LARGE),
			children(
				fieldset(
					title("Login"),
					frameType(FieldSet.FrameType.NONE),
					children(
						fieldLayout(
							labelWidth(20),
							fields(
								field(
									"User Name",
									textInput(
										ref(refUserId),
										mandatory()
									)
								),
								field(
									"Password",
									passwordInput(
										ref(refPasswordField),
										mandatory()
									)
								)
							)
						),
						panel(
							flowLayout(HAlign.RIGHT),
							children(
								button(
									ref(refLoginButton),
									text("Login")
								)
							)
						)
					)
				)
			)
		);

	/**
     * Creates a log-in screen.
     *
     * @param loginSuccessAction the action to execute on a successful log-in.
     */
    public LoginScreen(final Action loginSuccessAction)
    {
		add(section);

        refLoginButton.current().setAction(new ValidatingAction(WMessages.getInstance(this).getValidationErrors(), this)
        {
            @Override
            public void executeOnValid(final ActionEvent event)
            {
                loginSuccessAction.execute(event);
            }
        });
        setDefaultSubmitButton(refLoginButton.current());
    }

    /**
     * @return The user id which was entered into the text field.
     */
    protected String getUserId()
    {
        return refUserId.current().getText();
    }

    /**
     * Override validateComponent to validate the userId / password.
     * @param diags the list of diagnostics to add validation errors to.
     */
    @Override
    protected void validateComponent(final List<Diagnostic> diags)
    {
        if (!SecurityUtils.authenticate(refUserId.current().getText(), refPasswordField.current().getText()))
        {
            diags.add(createErrorDiagnostic(this, "Invalid user id / password"));
        }
    }
}
