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
  const [registerMessage, setRegisterMessage] = useState<string>('');
  const [loading, setLoading] = useState<boolean>(false);

  const handleSubmit = (event: any) => {
    event.preventDefault();
    setRegisterMessage('');
    setLoading(true);
    console.log(userData);
    sendToBackend();
  };

  const handleInput = (event: any) => {
    setUserData({ ...userData, [event.target.name]: event.target.value });
  };

  const sendToBackend = async () => {
    try {
      const response = await axios.post(url, userData, {
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (response.status === 201) {
        setRegisterMessage('Registration successful!');
      } else {
        setRegisterMessage('Registration failed.');
      }
    } catch (error: any) {
      setRegisterMessage(
        error.response?.data?.message ||
          'Something went wrong. Please try again.'
      );
      console.log(error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="body-registration">
      <section className="wrapper">
        <form className="register-form" onSubmit={handleSubmit}>
          <h2 className="registration-form-title">Registration</h2>
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
          <button type="submit" className="register-button" disabled={loading}>
            {loading ? 'Registering...' : 'Register'}
          </button>
          <div className="register">
            <p>
              Already have an account? <Link to="/login">Login</Link>
            </p>
          </div>
        </form>
        {registerMessage && (
          <div className="register-message">{registerMessage}</div>
        )}
      </section>
    </div>
  );
};

export default RegistrationForm;
