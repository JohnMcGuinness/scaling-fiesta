package com.github.johnmcguinness.exampleuicomponents.ui;

import com.github.johnmcguinness.exampleuicomponents.model.Customer;
import com.github.johnmcguinness.exampleuicomponents.util.DatabaseUtils;
import com.github.bordertech.wcomponents.ActionEvent;
import com.github.bordertech.wcomponents.Margin;
import com.github.bordertech.wcomponents.Size;
import com.github.bordertech.wcomponents.WButton;
import com.github.bordertech.wcomponents.WCancelButton;
import com.github.bordertech.wcomponents.WContainer;
import com.github.bordertech.wcomponents.WFieldLayout;
import com.github.bordertech.wcomponents.WFieldSet;
import com.github.bordertech.wcomponents.WMessages;
import com.github.bordertech.wcomponents.WPanel;
import com.github.bordertech.wcomponents.WSection;
import com.github.bordertech.wcomponents.WTextField;
import com.github.bordertech.wcomponents.WebUtilities;
import com.github.bordertech.wcomponents.layout.FlowLayout;
import com.github.bordertech.wcomponents.validation.ValidatingAction;
import com.github.johnmcguinness.wcomponents.ui.Ref;
import static com.github.johnmcguinness.wcomponents.ui.component.Field.field;
import static com.github.johnmcguinness.wcomponents.ui.component.FieldLayout.fieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;
import static com.github.johnmcguinness.wcomponents.ui.component.FieldSet.fieldset;
import com.github.johnmcguinness.wcomponents.ui.component.Section;
import static com.github.johnmcguinness.wcomponents.ui.component.Section.section;
import com.github.johnmcguinness.wcomponents.ui.component.TextInput;
import static com.github.johnmcguinness.wcomponents.ui.component.TextInput.textInput;
import static com.github.johnmcguinness.wcomponents.ui.property.ChildrenProperty.children;
import static com.github.johnmcguinness.wcomponents.ui.property.FieldsProperty.fields;
import static com.github.johnmcguinness.wcomponents.ui.property.FrameTypeProperty.frameType;
import static com.github.johnmcguinness.wcomponents.ui.property.LabelWidthProperty.labelWidth;
import static com.github.johnmcguinness.wcomponents.ui.property.LayoutProperty.verticalLayout;
import static com.github.johnmcguinness.wcomponents.ui.property.MandatoryProperty.mandatory;
import static com.github.johnmcguinness.wcomponents.ui.property.MarginProperty.margin;
import static com.github.johnmcguinness.wcomponents.ui.property.ReadOnlyProperty.readOnly;
import static com.github.johnmcguinness.wcomponents.ui.property.ReferenceProperty.ref;
import static com.github.johnmcguinness.wcomponents.ui.property.TitleProperty.title;

/**
 * This screen is used to edit customer details.
 */
public class EditScreen extends WContainer
{
	private final WSection section = new WSection("Edit customer details");
	
	private final Ref<TextInput> txtCustomerId
		= Ref.create();
	
	private final Ref<TextInput> txtFirstName
		= Ref.create();
	
	private final Ref<TextInput> txtLastName
		= Ref.create();

	private final Ref<TextInput> txtStreetAddress1
		= Ref.create();

	private final Ref<TextInput> txtStreetAddress2
		= Ref.create();

	private final Ref<TextInput> txtTownCity
		= Ref.create();

	private final Ref<TextInput> txtStateProvince
		= Ref.create();

	private final Ref<TextInput> txtCountry
		= Ref.create();


	/**
     * Creates an EditScreen.
     */
    public EditScreen()
    {
		Section section
			= section(
				margin(Size.LARGE),
				verticalLayout(Size.MEDIUM),
				children(
					fieldset(
						title("Customer details"),
						frameType(FieldSet.FrameType.NONE),
						children(
							fieldLayout(
								labelWidth(30),
								margin(Size.MEDIUM, Size.ZERO, Size.ZERO, Size.ZERO),
								fields(
									field(
										"Customer Id",
										textInput(
											ref(txtCustomerId),
											readOnly(true)
										)
									),
									field(
										"First name",
										textInput(
											ref(txtFirstName),
											mandatory()
										)
									),
									field(
										"Last name",
										textInput(
											ref(txtLastName),
											mandatory()
										)
									)
//									,field(
//										"Date of Birth",
//										dateInput(
//											ref(txtDateOfBirth),
//											mandatory()
//										)
//									)
								)
							)					
						)
					),
					fieldset(
						title("Customer address"),
						frameType(FieldSet.FrameType.NONE),
						children(
							fieldLayout(
								labelWidth(30),
								margin(Size.MEDIUM, Size.ZERO, Size.ZERO, Size.ZERO),
								fields(
									field(
										"Street address",
										textInput(
											ref(txtStreetAddress1),
											mandatory()
										)
									),
									field(
										"",
										textInput(
											ref(txtStreetAddress2)
										)
									),
									field(
										"Town/City",
										textInput(
											ref(txtTownCity),
											mandatory()
										)
									),
									field(
										"State/Province",
										textInput(
											ref(txtStateProvince),
											mandatory()
										)
									),
									field(
										"Country",
										textInput(
											ref(txtCountry)
										)
									)
								)
							)					
						)
					)
				)
			);
		
		add(section);
		
        // Customer details
//        section.getContent().add(fsCustomerDetails);

        // Customer address details
        WFieldSet fsCustomerAddress = new WFieldSet("Customer address");
		fsCustomerAddress.setFrameType(WFieldSet.FrameType.NO_BORDER);
        section.getContent().add(fsCustomerAddress);

        WFieldLayout flCustomerAddress = new WFieldLayout();
		flCustomerAddress.setMargin(new Margin(Size.MEDIUM, Size.ZERO, Size.ZERO, Size.ZERO));
		flCustomerAddress.setLabelWidth(30);
        fsCustomerAddress.add(flCustomerAddress);

//        WTextField addressLine1 = new WTextField();
//        addressLine1.setBeanProperty("address.line1");
//        addressLine1.setMandatory(true);
//        flCustomerAddress.addField("Street address", addressLine1);

//        WTextField addressLine2 = new WTextField();
//        addressLine2.setBeanProperty("address.line2");
//        flCustomerAddress.addField("Street address line 2", addressLine2).getLabel().setHidden(true);

//        WTextField city = new WTextField();
//        city.setBeanProperty("address.city");
//        city.setMandatory(true);
//        flCustomerAddress.addField("Town/City", city);

//        WTextField state = new WTextField();
//        state.setBeanProperty("address.state");
//        state.setMandatory(true);
//        flCustomerAddress.addField("State/Province", state);

//        WTextField country = new WTextField();
//        country.setBeanProperty("address.country");
//        addressLine1.setMandatory(true);
//        flCustomerAddress.addField("Country", country);

        WButton saveButton = new WButton("Save");
        WCancelButton cancelButton = new WCancelButton("Cancel");

        WPanel buttonPanel = new WPanel();
		buttonPanel.setMargin(new Margin(Size.LARGE, Size.ZERO, Size.ZERO, Size.ZERO));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.Alignment.RIGHT, Size.SMALL));
        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        section.getContent().add(buttonPanel);

        saveButton.setAction(new ValidatingAction(WMessages.getInstance(EditScreen.this).getValidationErrors(), EditScreen.this)
        {
            @Override
            public void executeOnValid(final ActionEvent event)
            {
                WebUtilities.updateBeanValue(EditScreen.this);
                Customer customer = (Customer) getBean();
                DatabaseUtils.save(customer);
                setCustomer(customer); // details may have been updated after save
                WMessages.getInstance(EditScreen.this).info("Customer saved succesfully.");
            }
        });

        cancelButton.setAction(e -> MyApp.getInstance(EditScreen.this).navigateToSearch());
    }

    /**
     * Sets the customer to edit.
     * @param customer the customer to edit.
     */
    public void setCustomer(final Customer customer)
    {
        reset(); // clear out any user data
        setBean(customer);

		this.txtCustomerId.current().setText(Integer.toString(customer.getCustomerId()));
		this.txtFirstName.current().setText(customer.getFirstName());
		this.txtLastName.current().setText(customer.getLastName());
    }
}
