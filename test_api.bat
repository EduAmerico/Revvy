@echo off
echo Testando API AI Tuning...
echo.

echo 1. Testando GET /api/users...
curl -X GET http://localhost:8080/api/users
echo.
echo.

echo 2. Criando usuario de teste...
curl -X POST http://localhost:8080/api/users ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"teste_user\",\"email\":\"teste@example.com\",\"password\":\"senha123\",\"firstName\":\"Usuario\",\"lastName\":\"Teste\",\"bio\":\"Usuario de teste\",\"isGarageOwner\":false}"
echo.
echo.

echo 3. Buscando usuario criado...
curl -X GET http://localhost:8080/api/users/1
echo.
echo.

echo Teste concluido!
pause
