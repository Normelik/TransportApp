type Inputs = {
  label: string;
  type: string;
  placeholder: string;
  required: boolean;
};
const InputField = ({ label, type, placeholder, required }: Inputs) => {
  return (
    <div>
      <label>{label}</label>
      <input type={type} placeholder={placeholder} required={required}></input>
    </div>
  );
};

export default InputField;
