import { useRef, useState, useEffect } from 'react';
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
  const [errorMessage, setErrorMessage] = useState<string>('');
  const [loading, setLoading] = useState<boolean>(false);
  const inputRef = useRef<HTMLInputElement | null>(null);

  const handleSubmit = (event: any) => {
    event.preventDefault();
    setRegisterMessage('');
    setLoading(true);
    console.log(userData);
    sendToBackend();
  };

  useEffect(() => {
    inputRef.current?.focus();
  }, []);

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
        setRegisterMessage('Registration was successful!');
      } else {
        setErrorMessage('Registration failed.');
      }
    } catch (error: any) {
      setErrorMessage(
        error.response?.data?.message ||
          'Something went wrong. Please try it again later.'
      );
      console.log(error);
    } finally {
      setLoading(false);
      setUserData({ username: '', password: '' });
    }
  };

  return (
    <div>
      <section className="flex mt-30 items-center justify-center">
        <form
          onSubmit={handleSubmit}
          className="flex flex-col gap-2.5 items-center border-2 w-70 h-70 rounded-3xl "
        >
          <h2 className="text-4xl py-4 font-extrabold text-gray-900">
            Registration
          </h2>
          <input
            className="border-2 border-green-500 rounded-sm"
            type="text"
            placeholder="Username"
            name="username"
            value={userData.username}
            onChange={handleInput}
            ref={inputRef}
            required
          />
          <input
            className="border-2 border-green-500 rounded-sm"
            type="password"
            placeholder="Password"
            name="password"
            value={userData.password}
            onChange={handleInput}
            required
          />
          <button
            className="bg-green-500 rounded-3xl w-30 p-3 shadow-green-900 shadow-2xs cursor-pointer"
            type="submit"
            disabled={loading}
          >
            {loading ? 'Registering...' : 'Register'}
          </button>

          <p>
            Already have an account?{' '}
            <Link className="text-blue-600 underline" to="/login">
              Login
            </Link>
          </p>
        </form>
      </section>
      <div className="flex justify-center text-red-600">
        {errorMessage && <div>{errorMessage}</div>}
      </div>
      <div className="flex justify-center text-green-600 text-2xl">
        {registerMessage && <div>{registerMessage}</div>}
      </div>
    </div>
  );
};

export default RegistrationForm;
