import { useState } from 'react';
import './RegistrationForm.css';
import axios from 'axios';
import { Link } from 'react-router-dom';

type userData = {
  username: string;
  password: string;
};

const url = 'http://localhost:8080/public/register';

const RegistrationForm = () => {
  const [userData, setUserData] = useState<userData>({
    username: '',
    password: '',
  });

  const handleSubmit = (event: any) => {
    event.preventDefault();
    console.log(userData);
    sendToBackend();
  };

  const handleInput = (event: any) => {
    setUserData({ ...userData, [event.target.name]: event.target.value });
  };

  const sendToBackend = async () => {
    await axios
      .post(url, userData, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => console.log(response))
      .catch((error) => {
        console.log(error);
      });
    setUserData({ username: '', password: '' });
  };

  return (
    <section className="wrapper">
      <form className="register-form" onSubmit={handleSubmit}>
        <h2 className="registration-form-title"> Registration</h2>
        <div className="input-field">
          <input
            type="text"
            placeholder="Username"
            name="username"
            value={userData.username}
            onChange={handleInput}
            required
          />
        </div>
        <div className="input-field">
          <input
            className="input-placeholder"
            type="password"
            placeholder="Password"
            name="password"
            value={userData.password}
            onChange={handleInput}
            required
          />
        </div>
        <button type="submit" className="register-button">
          Register
        </button>
        <div className="register">
          <p>
            Already have an account? <Link to="/login">Login</Link>
          </p>
        </div>
      </form>
    </section>
  );
};

export default RegistrationForm;
